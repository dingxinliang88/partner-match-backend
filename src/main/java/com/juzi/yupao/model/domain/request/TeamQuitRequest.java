package com.juzi.yupao.model.domain.request;

import lombok.Data;

import java.io.Serializable;

/**
 * 退出队伍请求参数
 *
 * @author codejuzi
 */
@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = -6451311352893994157L;

    /**
     * id
     */
    private Long teamId;
}
