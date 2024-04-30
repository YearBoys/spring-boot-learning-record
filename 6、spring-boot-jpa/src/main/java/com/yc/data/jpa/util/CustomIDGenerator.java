package com.yc.data.jpa.util;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

import java.io.Serializable;

/**
 * 自定义ID生成器
 */
public class CustomIDGenerator extends IdentityGenerator {


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        // 数据库中id 属性为String  所以需要转换为String类型
        return IdUtils.getId().toString() ;
    }
}