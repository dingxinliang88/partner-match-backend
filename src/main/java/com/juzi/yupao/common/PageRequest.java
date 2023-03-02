package com.juzi.yupao.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页请求通用类
 *
 * @author codejuzi
 */
@Data
public class PageRequest implements Serializable {


    private static final long serialVersionUID = 2024083731129442984L;

    /**
     * 页面大小
     */
    private int pageSize = 5;

    /**
     * 当前是第几页
     */
    private int pageNum = 1;
}
