package com.yc.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 上午10:33 2024/4/30
 */
@SpringBootApplication
public class SpringBootRedisApplication {

    public static void main(String[] args) {
        // 启动springboot
       SpringApplication.run(SpringBootRedisApplication.class, args);
    }
}
