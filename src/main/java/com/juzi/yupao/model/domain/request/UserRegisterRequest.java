package com.juzi.yupao.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户注册请求体
 *
 * @author codejuzi
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 42L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String planetCode;
}
