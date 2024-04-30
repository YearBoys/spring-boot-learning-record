package com.yc.redis.lettuce;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;

import java.util.List;

/**
 *  高级特性
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 下午3:19 2024/4/30
 */
@SpringBootTest
public class RedisLettuceAdvancedTest {



    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * redis的事务管理,要保证事务的开启和提交是同一条连接。
     */
    @Test
    public void transcation(){
        List results = (List) redisTemplate.execute(new SessionCallback() {
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                //开启事务
                redisOperations.multi();
                //进行操作
                redisOperations.opsForValue().set("name", "张三");
                redisOperations.opsForValue().get("name");
                //提交事务
                List result = redisOperations.exec();
                return result;
            }
        });
        System.out.println("-->" + results);
    }

}
