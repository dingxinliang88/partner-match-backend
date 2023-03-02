package com.juzi.yupao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.juzi.yupao.model.domain.UserTeam;
import com.juzi.yupao.mapper.UserTeamMapper;
import com.juzi.yupao.service.UserTeamService;
import org.springframework.stereotype.Service;

/**
* @author codejuzi
* @description 针对表【user_team(用户队伍关系)】的数据库操作Service实现
* @createDate 2022-12-22 20:21:21
*/
@Service
public class UserTeamServiceImpl extends ServiceImpl<UserTeamMapper, UserTeam>
    implements UserTeamService {

}




