package com.yc.mybatis.listener;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 泛型监听ioc容器
 *
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 16:07 2023/5/9
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer {


    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        System.out.println("ApplicationContextInitializer...跑起来了....."+applicationContext);
    }
}
