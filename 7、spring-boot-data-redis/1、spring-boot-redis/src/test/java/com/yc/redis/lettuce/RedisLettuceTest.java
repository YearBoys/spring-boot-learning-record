package com.yc.redis.lettuce;

import com.yc.redis.lettuce.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 *  redis 基本操作
 *    操作 String  hash set list zset
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 上午11:05 2024/4/30
 */
@SpringBootTest
public class RedisLettuceTest {

    private Logger logger = LoggerFactory.getLogger(RedisLettuceTest.class);


    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * redis 操作String 类型
     */
    @Test
    public void testString() {
        String key = "user:1";

        redisUtils.set(key, new BootUser("1", "pjmike", "20", 20, null, null),100);
        BootUser user = (BootUser) redisUtils.get(key);
        logger.info("BootUser: " + user.toString());
        System.out.println(redisUtils.hasKey(key));
    }

    /**
     * redis 操作Hash 类型
     */
    @Test
    public void testHash(){
        //hset hget hdel hkeys hvals
        // 设置k为100，哈希k为name v为100
        redisUtils.hset("100","name","tom");
        redisUtils.hset("100","age","20");

        // 获取k为100，hashk为name的v
        String name = (String) redisUtils.hget("100", "name");
        System.out.println(name);
        Map<Object, Object> hmget = redisUtils.hmget("100");
        System.out.println(hmget);
       // 获取k为100的集合k
        Set hasKey = redisUtils.hkeys("100");
        System.out.println(hasKey);
        // 获取k为100的集合k
        List hvalues = redisUtils.hvalues("100");
        System.out.println(hvalues);
        // 删除age字段
        redisUtils.hdel("100","age");

    }

    /**
     * redis 操作List 类型
     */
    @Test
    public void testList(){
        redisUtils.lSet("mylist",Arrays.asList("a","b","c"));
        redisUtils.lSet("mylist","d");
        List<Object> muylist = redisUtils.lGet("mylist", 0, -1);
        System.out.println(muylist); // 输出
        // 删除10个 值为a的数据  1可以是多个
        redisUtils.lRemove("mylist",1,"a");
        System.out.println(redisUtils.lGetListSize("mylist"));

    }


    /**
     * redis 操作集合类型
     */
    @Test
    public void testSet(){
        //sadd smembers scard sinter sunion srem
        redisUtils.sSet("set1","a","b","c","d");
        redisUtils.sSet("set2","a","b","x","y");
        Set members =  redisUtils.sGet("set1");
        System.out.println(members); // 输出
//        Set intersect = setOperations.intersect("set1", "set2"); // 他们的交集
        // 在set1里面删除ab
        redisUtils.setRemove("set1","a","b");

    }

    /**
     * redis 操作有序集合类型的数据
     */
    @Test
    public void testZSet() {
        //zadd zrange zincrby zrem
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();

        zSetOperations.add("zset1", "a", 10); // 设置k为zset1v为a，分数为10
        zSetOperations.add("zset1", "b", 12); //同理
        zSetOperations.add("zset1", "c", 9); // 同理

        Set zset1 = zSetOperations.range("zset1", 0, -1);
        System.out.println(zset1); // 输出

        zSetOperations.incrementScore("zset1", "c", 10); // 为k为zset1v为c的加10分

        zSetOperations.remove("zset1", "a", "b"); // 删除ab

    }


}