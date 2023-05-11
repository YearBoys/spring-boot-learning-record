package com.yc.mybatis.service.impl;

import com.yc.mybatis.domain.User;
import com.yc.mybatis.mapper.UserMapper;
import com.yc.mybatis.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 17:40 2023/5/6
 */
@Service
public class UserServiceImpl implements UserService {


    final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> queryUserList() {
        return userMapper.queryUserList();
    }
}
