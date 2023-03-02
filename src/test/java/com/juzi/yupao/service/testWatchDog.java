package com.juzi.yupao.service;

import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class testWatchDog {

    @Resource
    private RedissonClient redissonClient;

    @Test
    void test() {
        RLock rLock = redissonClient.getLock("yupao:precachejob:docache:lock");

        try {
            // 只有一个线程能获取到锁
            if(rLock.tryLock(0, -1, TimeUnit.MILLISECONDS)) {
                Thread.sleep(300000);
                System.out.println("getLock:" + Thread.currentThread().getId());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // 只能释放自己的锁
            if(rLock.isHeldByCurrentThread()) {
                System.out.println("unLock:" + Thread.currentThread().getId());
                rLock.unlock();
            }
        }
    }
}
