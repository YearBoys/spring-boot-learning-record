package com.yc.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.mybatis.plus.service.UserService;
import com.yc.mybatis.plus.domain.User;
import com.yc.mybatis.plus.mapper.User1Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 16:48 2023/5/8
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<User1Mapper, User> implements UserService {

    @Autowired
   private User1Mapper user1Mapper;

    @Override
    public User insterUser(User user) {
        user.setAddress("测试");
        user.setAccountNumber("测试");
        user.setPassword("12051256@qq.com");
        user.setCreatTime(new Date());
        System.out.println("添加前:==="+user);
        int row = user1Mapper.insert(user);
        System.out.println("添加后:==="+user);
        return user;
    }
}
