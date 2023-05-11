package com.yc.mybatis.plus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.mybatis.plus.service.UserService;
import com.yc.mybatis.plus.domain.User;
import com.yc.mybatis.plus.mapper.User1Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 16:48 2023/5/8
 */
@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<User1Mapper, User> implements UserService {
}
