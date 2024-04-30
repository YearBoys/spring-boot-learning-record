package com.yc.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yc.mybatis.plus.SpringBoot5MybatisPlus;
import com.yc.mybatis.plus.domain.User;
import com.yc.mybatis.plus.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * mybatis-plus ：<a href="https://www.baomidou.com/">官网文档</a>
 *
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 16:36 2023/5/8
 */
@SpringBootTest
public class User1MapperTest {

    @Autowired
    private User1Mapper userMapper;

    @Autowired
    private UserService userService;


    String dateString = "2023-01-02";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 查询全部
     */
    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assertions.assertEquals(userList.size(),13);
        userList.forEach(System.out::println);
    }

    /**
     * 根据Id 查询
     */
    @Test
    public void testSelectById() {
        User user = userService.getById("1");
        System.out.println(user);
    }

    /**
     * 不同条件查询 多条
     */
    @Test
    public void testSelectByCondition() throws ParseException {
        QueryWrapper<User> wrapper=new QueryWrapper<>();
        wrapper.between("creat_time",dateFormat.parse(dateString) ,  new Date() ); //creat_time 在 2023-1-2 到当前时间 范围
//        wrapper.select("creat_time","password");   //查询name,age这两列   默认查全部
        //wrapper.or();   //默认中间都是and连接
        wrapper.like("password","an");   //password like %an%
        userMapper.selectList(wrapper).forEach(System.out::println);
    }


    /**
     * 特定条件查询一条
     * @throws ParseException
     */
    @Test
    public void testSelectOne() throws ParseException {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("password","gpt");
        wrapper.gt("creat_time",dateFormat.parse(dateString));   //creat_time 大于指定时间
        wrapper.lt("creat_time",new Date());   //creat_time 小于当前时间
//        wrapper.ge("creat_time",dateFormat.parse(dateString));   //creat_time 大于指定时间
//        wrapper.le("creat_time",new Date());   //creat_time 小于当前时间
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    /**
     * 新增
     */
    @Test
    public void testInsert(){
        User user = new User();
        user.setAddress("测试");
        user.setAccountNumber("测试");
        user.setPassword("12051256@qq.com");
        user.setCreatTime(new Date());
        System.out.println("添加前:==="+user);
        int row = userMapper.insert(user);
        System.out.println("添加后:==="+user);

    }

    /**
     * 修改
     */
    @Test
    public void testUpdate(){
        User user = new User();
        user.setId("14");
        user.setAddress("张学友");
        //根据主键进行修改
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    /**
     * 删除
     */
    @Test
    public void testDelete(){
        //根据主键删除
        int i = userMapper.deleteById(14);
        System.out.println(i);
    }


}