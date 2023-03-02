package com.juzi.yupao.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.juzi.yupao.common.DeleteRequest;
import com.juzi.yupao.model.domain.Team;
import com.juzi.yupao.model.domain.User;
import com.juzi.yupao.model.domain.request.TeamJoinRequest;
import com.juzi.yupao.model.domain.request.TeamQuitRequest;
import com.juzi.yupao.model.domain.request.TeamUpdateRequest;
import com.juzi.yupao.model.dto.TeamQuery;
import com.juzi.yupao.model.vo.TeamUserVO;

import java.util.List;

/**
* @author codejuzi
* @description 针对表【team(队伍)】的数据库操作Service
* @createDate 2022-12-22 20:21:10
*/
public interface TeamService extends IService<Team> {


    /**
     * 添加队伍
     *
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);

    /**
     * 查询队伍信息
     *
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍信息
     *
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     *
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     *
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除队伍
     *
     * @param deleteRequest
     * @param loginUser
     * @return
     */
    boolean deleteTeam(DeleteRequest deleteRequest, User loginUser);
}
