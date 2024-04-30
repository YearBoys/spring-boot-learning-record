package com.yc.mybatis.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 15:43 2023/5/6
 */
//@Component
@ConfigurationProperties(prefix = "yc.config")
@Data
public class ConfigBean {


    private String name;
    private String title;
    private String wholeTitle;
}
