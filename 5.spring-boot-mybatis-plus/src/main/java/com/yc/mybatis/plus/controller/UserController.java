package com.yc.mybatis.plus.controller;

import com.yc.mybatis.plus.service.UserService;
import com.yc.mybatis.plus.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 16:20 2023/5/8
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 根据id 查询
     * @return
     */
    @GetMapping("/{id}")
    User queryUser(@Validated String id) {
        return userService.getById(id);
    }


    /**
     * 查询全部
     * @return
     */
    @GetMapping
    List<User> queryListUser() {
        return userService.list();
    }


    /**
     * TODO 增删改 查看测试类
     *
     */
}
