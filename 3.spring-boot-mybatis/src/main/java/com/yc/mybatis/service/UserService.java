package com.yc.mybatis.service;

import com.yc.mybatis.domain.User;

import java.util.List;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 17:40 2023/5/6
 */
public interface UserService {

    List<User> queryUserList();
}
