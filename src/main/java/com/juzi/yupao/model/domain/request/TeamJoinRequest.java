package com.juzi.yupao.model.domain.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 加入队伍请求参数
 *
 * @author codejuzi
 */
@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = 3725145440817749066L;

    /**
     * id
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;

}
