package com.juzi.yupao.service;

import com.juzi.yupao.model.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.juzi.yupao.model.domain.request.UserUpdateRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author codejuzi
* @description 针对表【user(用户表)】的数据库操作Service
* @createDate 2022-11-11 10:53:20
*/
public interface UserService extends IService<User> {



    /**
     * 用户注册
     *
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param checkPassword 校验密码
     * @param planetCode 星球编号
     * @return 新用户id
     */
    long userRegister(String userAccount,String userPassword,String checkPassword,String planetCode);


    /**
     * 用户登陆
     *
     * @param userAccount 用户账号
     * @param userPassword 用户密码
     * @param request
     * @return 脱敏后的用户信息
     */
    User userLogin(String userAccount,String userPassword, HttpServletRequest request);


    /**
     * 用户登出
     *
     * @param request
     * @return
     */
    int userLogout(HttpServletRequest request);

    /**
     * 用户脱敏
     *
     * @param originUser
     * @return
     */
    User getSafetyUser(User originUser);

    /**
     * 根据标签搜索用户（基于内存过滤）
     *
     * @param tagNameList 用户拥有的标签
     * @return
     */
    List<User> searchUsersByTags(List<String> tagNameList);

    /**
     * 根据标签搜索用户(SQL查询版）
     *
     * @param tagNameList 用户拥有的标签
     * @return
     */
    List<User> searchUsersByTagsBySQL(List<String> tagNameList);


    /**
     * 获取当前登录的用户
     *
     * @param request
     * @return
     */
    User getLoginUser(HttpServletRequest request);

    /**
     * 更新用户信息
     *
     * @param userUpdateRequest
     * @param loginUser
     * @return
     */
    int updateUser(UserUpdateRequest userUpdateRequest, User loginUser);

    /**
     * 是否是管理员
     *
     * @param request
     * @return
     */
    boolean isAdmin(HttpServletRequest request);

    /**
     * 是否是管理员
     *
     * @param loginUser
     * @return
     */
    boolean isAdmin(User loginUser);


    /**
     * 获得最匹配的用户
     *
     * @param num
     * @param loginUser
     * @return
     */
    List<User> matchUsers(long num, User loginUser);
}