package com.yc;

import com.yc.bean.ConfigBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 15:42 2023/5/6
 *
 *
 * @EnableConfigurationProperties 作用: 将@ConfigurationProperties 修饰的类，加载到 Spring Env 中。
 *    {@link ConfigBean}
 *    经测试 @Component 也能起到同样作用
 *
 */
@SpringBootApplication
@EnableConfigurationProperties({ConfigBean.class})
public class SpringBootConfig {


    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringBootConfig.class);
        app.setAddCommandLineProperties(false);
        app.run(args);
    }
}
