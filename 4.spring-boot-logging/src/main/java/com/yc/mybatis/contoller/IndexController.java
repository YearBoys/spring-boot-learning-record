package com.yc.mybatis.contoller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 14:47 2023/5/8
 */
@Slf4j
@RestController
public class IndexController {


    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        log.trace("hello word");
        return "hello word";
    }
}
