package com.juzi.yupao.model.domain.request;

import lombok.Data;

import java.io.Serializable;


/**
 * 更新用户请求数据
 *
 * @author codejuzi
 */
@Data
public class UserUpdateRequest implements Serializable {
    private static final long serialVersionUID = 8548564920858940560L;
    /**
     *
     */
    private Long id;

    /**
     * 用户昵称
     */
    private String username;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 电话
     */
    private String phone;


    /**
     * 邮箱
     */
    private String email;


    /**
     * 标签列表 json
     */
    private String tags;

    /**
     * 个人简介
     */
    private String profile;


}
