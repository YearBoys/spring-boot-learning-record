package com.yc.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 15:25 2023/5/6
 */
@RestController
@SpringBootApplication
public class SpringbootStart {


    public static void main(String[] args) {
        SpringApplication.run(SpringbootStart.class,args);
    }


    @GetMapping("/hello")
    public String hello(){
        return "hello word";
    }
}
