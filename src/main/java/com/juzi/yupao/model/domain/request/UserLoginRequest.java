package com.juzi.yupao.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登陆请求体
 *
 * @author codejuzi
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 2598644572712475469L;

    private String userAccount;

    private String userPassword;

}
