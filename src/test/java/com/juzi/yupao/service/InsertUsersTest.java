package com.juzi.yupao.service;

import java.util.Date;

import com.juzi.yupao.model.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@SpringBootTest
public class InsertUsersTest {
    @Resource
    private UserService userService;


    @Test
    public void doInsertUsers() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        final int INSERT_NUM = 100000;
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < INSERT_NUM; i++) {
            User user = new User();
            user.setUsername("患者" + i);
            user.setUserAccount("patient" + (i | 0xff));
            user.setAvatarUrl("https://raw.githubusercontent.com/dingxinliang88/figure/master/img/patient.png");
            user.setUserPassword("12345678");
            user.setGender(0);
            user.setUserStatus(0);
            user.setPhone("123456789");
            user.setEmail("12345678@patient.com");
            user.setUserRole(0);
            user.setPlanetCode("213213");
            user.setTags("['${年限}','${程度}','${性别}','${特点}']");
            user.setProfile("一名需要关注的抑郁症患者");
            userList.add(user);
        }
        userService.saveBatch(userList);
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis()); // 14s
    }

    private final ExecutorService executorService = new ThreadPoolExecutor(40,1000,10000, TimeUnit.MINUTES,new ArrayBlockingQueue<>(10000));

    @Test
    public void doConcurrencyInsertUsers(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        //分10组
        int batchSize = 10000;
        int j=0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            List<User> userList = new ArrayList<>();
            do {
                j++;
                User user = new User();
                user.setUsername("患者" + i);
                user.setUserAccount("patient" + i);
                user.setAvatarUrl("https://raw.githubusercontent.com/dingxinliang88/figure/master/img/patient.png");
                user.setUserPassword("12345678");
                user.setGender(0);
                user.setUserStatus(0);
                user.setPhone("123456789");
                user.setEmail("12345678@patient.com");
                user.setUserRole(0);
                user.setPlanetCode("213213");
                user.setTags("[\"${年限}\",\"${程度}\",\"${性别}\",\"${特点}\"]");
                user.setProfile("一名需要关注的抑郁症患者");
                userList.add(user);
                userList.add(user);
            } while (j % batchSize != 0);
            //异步执行
            CompletableFuture<Void> future = CompletableFuture.runAsync(() ->{
                System.out.println("threadName:"+Thread.currentThread().getName());
                userService.saveBatch(userList,batchSize);
            },executorService);
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();

        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}

