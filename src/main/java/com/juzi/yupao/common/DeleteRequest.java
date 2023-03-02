package com.juzi.yupao.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求统一参数
 *
 * @author codejuzi
 */
@Data
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = 3725145440817749066L;

    /**
     * id
     */
    private Long id;


}
