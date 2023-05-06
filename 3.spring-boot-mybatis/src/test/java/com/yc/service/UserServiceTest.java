package com.yc.service;

import com.yc.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 18:15 2023/5/6
 */
public class UserServiceTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void queryUserList() {
        System.out.println(userMapper.queryUserList());
    }
}