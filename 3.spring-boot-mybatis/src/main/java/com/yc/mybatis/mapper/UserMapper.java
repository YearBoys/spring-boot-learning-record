package com.yc.mybatis.mapper;

import com.yc.mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 17:39 2023/5/6
 */
@Mapper
public interface UserMapper {

    /**
     * 查询全部用户信息
     * @return
     */
    List<User> queryUserList();
}
