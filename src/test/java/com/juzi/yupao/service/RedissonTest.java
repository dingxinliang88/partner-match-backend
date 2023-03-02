package com.juzi.yupao.service;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;

@SpringBootTest
public class RedissonTest {

    @Resource
    private RedissonClient redissonClient;

    @Test
    public void test() {
        // List 数据保存在本题JVM内存
        ArrayList<Object> list = new ArrayList<>();
        list.add("juzi");
        System.out.println("list:" + list.get(0));
        list.remove(0);
        // RList 数据保存在redis内存
        RList<Object> rList = redissonClient.getList("test-rList");
        rList.add("juzi");
        System.out.println("rList:" + rList.get(0));
        rList.remove(0);
    }
}
