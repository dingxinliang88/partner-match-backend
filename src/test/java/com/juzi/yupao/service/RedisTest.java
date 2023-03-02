package com.juzi.yupao.service;

import com.juzi.yupao.model.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest {

    @Resource
    private RedisTemplate redisTemplate;

    @Test
    void Test() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        // 增
        valueOperations.set("juziString","dog");
        valueOperations.set("juziInt", 1);
        valueOperations.set("juziDouble", 2.0);
        User user = new User();
        user.setId(1L);
        user.setUsername("juzi");
        valueOperations.set("juziUser", user);
        // 查
        Object juzi = valueOperations.get("juziString");
        Assertions.assertTrue("dog".equals((String)juzi));
        juzi = valueOperations.get("juziInt");
        Assertions.assertTrue(1 == (Integer)juzi);
        juzi = valueOperations.get("juziDouble");
        Assertions.assertTrue(2.0 == (Double)juzi);
        System.out.println(valueOperations.get("juziUser"));
    }
}
