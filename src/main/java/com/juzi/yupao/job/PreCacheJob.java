package com.juzi.yupao.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.juzi.yupao.constant.RedisConstant;
import com.juzi.yupao.model.domain.User;
import com.juzi.yupao.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 定时任务，缓存预热
 *
 * @author codejuzi
 */
@Slf4j
@Component
public class PreCacheJob {
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private RedissonClient redissonClient;


    private static final Long TIME_WAIT = 30000L;

    /**
     * 重点用户
     */
    private final List<Long> mainUserList = Arrays.asList(1L, 2L);

    /**
     * 每天0点执行，预热匹配患者（分布式锁，保证线程安全）
     */
    @Scheduled(cron = "0 0 0 * * *")
    public void doCacheRecommendUser() {
        RLock rLock = redissonClient.getLock(RedisConstant.PRECACHE_JOB_LOCK_KEY);

        try {
            // 只有一个线程能获取到锁
            if(rLock.tryLock(0, TIME_WAIT,TimeUnit.MILLISECONDS)) {
                for (Long userId : mainUserList) {
                    QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20), userQueryWrapper);
                    String redisKey = RedisConstant.USER_RECOMMEND_KEY_PREFIX + userId;
                    ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                    // 写缓存
                    try {
                        valueOperations.set(redisKey, userPage, 3000, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        log.error("redis set key error,", e);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 只能释放自己的锁
            if(rLock.isHeldByCurrentThread()) {
                rLock.unlock();
            }
        }
    }
}
