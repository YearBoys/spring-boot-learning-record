package com.yc.mybatis.plus.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yc.mybatis.plus.service.UserService;
import com.yc.mybatis.plus.domain.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    final UserService userService;

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
     * 新增
     */
    @PutMapping
    User insterUser(User user) {
        return   userService.insterUser(user);
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    boolean updateUser(User user) {
        return userService.updateById(user);
    }


    /**
     * mybatis-plus分页查询
     */
    @GetMapping("/page")
    Page<User> page(int current, int size) {
       //当页数为空时 设置默认值 默认展示10条数据 第一页
        if (current < 1) {
            current = 1;
        }
        if (size < 1) {
            size = 10;
        }
        return userService.page(new Page<>(current, size));
    }

}
