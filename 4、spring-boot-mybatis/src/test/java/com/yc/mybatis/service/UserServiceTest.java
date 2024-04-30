package com.yc.mybatis.service;

import com.yc.mybatis.SpringBootMybatis;
import com.yc.mybatis.dao.BootUserDao;
import com.yc.mybatis.entity.BootUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 18:15 2023/5/6
 */
@SpringBootTest(classes = SpringBootMybatis.class)
public class UserServiceTest {

    @Autowired
    BootUserDao userMapper;

    @Test
    public void queryUserList() {
        System.out.println(userMapper.selectAll());
    }





    @Test
    public void queryPageList(){
        List<BootUser> bootUsers = userMapper.selectPage(1, 10);
        bootUsers.forEach(System.out::println);
        bootUsers.forEach(bootUser -> System.out.println(bootUser.getId()));
    }
}