package com.yc.redis.queue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 *
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 下午4:29 2024/4/30
 */
@SpringBootApplication
@EnableScheduling
public class SpringbootRedisQueueApplication
{
    public static void main(String[] args)
    {

        SpringApplication.run(SpringbootRedisQueueApplication.class, args);
    }

}
