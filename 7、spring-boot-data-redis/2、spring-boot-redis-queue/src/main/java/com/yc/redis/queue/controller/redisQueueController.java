package com.yc.redis.queue.controller;

import com.yc.redis.queue.serve.common.redis.DelayQueue;
import com.yc.redis.queue.serve.domain.DelayMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 下午4:41 2024/4/30
 */
@RestController("/queue")
@Slf4j
public class redisQueueController {

    @Autowired
    private  DelayQueue delayQueue;

    @PostMapping("/add")
    public void test(){
        DelayMessage delayMessage =new DelayMessage();
        delayMessage.setId(UUID.randomUUID().toString());
        delayMessage.setContent("hello world");
        // 十秒后执行
        delayMessage.setExpireTime(System.currentTimeMillis()+1000*10);
        delayQueue.put(delayMessage);
        log.info("消息添加成功");
    }

}
