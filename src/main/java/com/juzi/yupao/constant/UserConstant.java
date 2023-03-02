package com.juzi.yupao.constant;

/**
 * 用户常量
 *
 * @author codejuzi
 */
public interface UserConstant {

    /**
     * 用户登陆态键
     */
    String USER_LOGIN_STATE = "userLoginState";

    // ========== 权限 ===========
    /**
     * 管理员
     */
    int ADMIN_ROLE = 1;

    /**
     * 普通用户
     */
    int DEFAULT_ROLE = 0;


    // =========校验==========
    /**
     * 不能包含特殊字符的正则表达式
     */
    String VALID_PATTERN = "^[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]$";

    // ========加密=========

    /**
     * 盐值
     */
    String SALT = "codejuzi";
}
