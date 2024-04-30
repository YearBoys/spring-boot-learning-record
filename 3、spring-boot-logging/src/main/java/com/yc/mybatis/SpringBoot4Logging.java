package com.yc.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 11:39 2023/5/8
 */
@SpringBootApplication
@Slf4j
public class SpringBoot4Logging {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot4Logging.class,args);
      log.info("启动成功");
    }
}
