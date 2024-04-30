package com.yc.mybatis.plus.config;

import com.baomidou.mybatisplus.core.incrementer.IdentifierGenerator;
import com.yc.mybatis.plus.utils.id.IdUtils;
import org.springframework.stereotype.Component;


/**
 *  自定义 id 生成策略
 */
@Component
public class CustomIdGenerator implements IdentifierGenerator {
    @Override
    public Long nextId(Object entity) {
      	//可以将当前传入的class全类名来作为bizKey,或者提取参数来生成bizKey进行分布式Id调用生成.
      	String bizKey = entity.getClass().getName();
        //根据bizKey调用分布式ID生成
        long id = IdUtils.getId();
      	//返回生成的id值即可.
        return id;
    }
}