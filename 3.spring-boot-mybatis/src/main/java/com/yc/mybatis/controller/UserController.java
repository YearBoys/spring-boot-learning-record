package com.yc.mybatis.controller;

import com.yc.mybatis.domain.User;
import com.yc.mybatis.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 17:41 2023/5/6
 */
@RestController
public class UserController {

  final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/queryUserList")
    List<User> queryUserList(){
        return userService.queryUserList();
    }

    /**
     *  增删改忽略......
     */
}
