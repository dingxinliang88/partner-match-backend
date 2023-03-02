package com.juzi.yupao.model.domain.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 更新队伍请求参数
 *
 * @author codejuzi
 */
@Data
public class TeamUpdateRequest implements Serializable {

    private static final long serialVersionUID = 3725145440817749066L;

    /**
     * id
     */
    private Long id;

    /**
     * 队伍名称
     */
    private String name;

    /**
     * 描述
     */
    private String description;

    /**
     * 最大人数
     */
    private Integer maxNum;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 用户id（队长 id）
     */
    private Long userId;

    /**
     * 0 - 公开，1 - 私有，2 - 加密
     */
    private Integer status;

    /**
     * 密码
     */
    private String password;
}
