package com.yc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 17:23 2023/5/6
 */
@SpringBootApplication
@MapperScan("com.yc.mapper")
public class SpringBootMybatis {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootMybatis.class);
        app.setAddCommandLineProperties(true);
        app.run(args);
    }

}
