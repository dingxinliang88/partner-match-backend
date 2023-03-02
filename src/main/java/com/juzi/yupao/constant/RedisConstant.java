package com.juzi.yupao.constant;

/**
 * Redis常量
 *
 * @author codejuzi
 */
public interface RedisConstant {
    String USER_RECOMMEND_KEY_PREFIX = "yupao:user:recommend:";

    String PRECACHE_JOB_LOCK_KEY = "yupao:precachejob:docache:lock";

    String TEAM_CREATE_LOCK_KEY_PREFIX = "yupao:team:create:lock";
}
