package com.juzi.yupao.service;

import com.juzi.yupao.model.domain.User;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * 用户服务测试类
 *
 * @author codejuzi
 */
@SpringBootTest
class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUsername("dogJuzi");
        user.setUserAccount("123");
        user.setAvatarUrl("https://xingqiu-tuchuang-1256524210.cos.ap-shanghai.myqcloud.com/5143/Q版瞎子.png");
        user.setUserPassword("xxx");
        user.setGender(0);
        user.setPhone("456");
        user.setEmail("123@163.com");

        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assert.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "juzi";
        String userPassword = " ";
        String checkedPassword = "123456";
        String planetCode = "5143";

        // 密码长度限制
        long result = userService.userRegister(userAccount,userPassword,checkedPassword,planetCode);
        Assertions.assertEquals(-1,result);

        // 账号长度限制
        userAccount = "ju";
        result = userService.userRegister(userAccount,userPassword,checkedPassword,planetCode);
        Assertions.assertEquals(-1,result);

        // 密码长度限制
        userAccount = "juzi";
        userPassword = "123456";
        result = userService.userRegister(userAccount,userPassword,checkedPassword,planetCode);
        Assertions.assertEquals(-1,result);

        // 特殊字符
        userAccount = "ju zi";
        userPassword = "12345678";
        result = userService.userRegister(userAccount,userPassword,checkedPassword,planetCode);
        Assertions.assertEquals(-1,result);

        // 密码 == 校验密码
        checkedPassword = "123456789";
        result = userService.userRegister(userAccount,userPassword,checkedPassword,planetCode);
        Assertions.assertEquals(-1,result);

        // 账号存在
        userAccount = "dogJuzi";
        checkedPassword = "12345678";
        result = userService.userRegister(userAccount,userPassword,checkedPassword,planetCode);
        Assertions.assertEquals(-1,result);

        // 成功插入
        userAccount = "juzi";
        result = userService.userRegister(userAccount,userPassword,checkedPassword,planetCode);
        Assertions.assertTrue(result > 0);
    }

    @Test
    void searchUsersByTags() {
        List<String> tagNameList = Arrays.asList("java","python");
        List<User> userList = userService.searchUsersByTags(tagNameList);
        Assertions.assertNotNull(userList);
    }
}