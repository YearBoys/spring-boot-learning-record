package com.yc.mybatis.service;

import com.yc.mybatis.SpringBootMybatis;
import com.yc.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 18:15 2023/5/6
 */
@SpringBootTest(classes = SpringBootMybatis.class)
public class UserServiceTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void queryUserList() {
        System.out.println(userMapper.queryUserList());
    }
}