package com.yc.mybatis.service;


import java.util.List;

import com.yc.mybatis.entity.BootUser;

/**
 * (BootUser)表服务接口
 *
 * @author yangc
 * @since 2024-04-28 17:42:17
 */
public interface BootUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BootUser selectById(String id);

//    /**
//     * 分页查询
//     *
//     * @param start 查询起始位置
//     * @param limit 查询条数
//     * @return 对象列表
//     */
//    PageResult selectPage(int start, int limit);

    /**
     * 查询全部
     *
     * @return 对象列表
     */
    List<BootUser> selectAll();

    /**
     * 通过实体作为筛选条件查询
     *
     * @param bootUser 实例对象
     * @return 对象列表
     */
    List<BootUser> selectList(BootUser bootUser);

    /**
     * 新增数据
     *
     * @param bootUser 实例对象
     * @return 影响行数
     */
    int insert(BootUser bootUser);

    /**
     * 批量新增
     *
     * @param bootUsers 实例对象的集合
     * @return 影响行数
     */
    int batchInsert(List<BootUser> bootUsers);

    /**
     * 修改数据
     *
     * @param bootUser 实例对象
     * @return 修改
     */
    BootUser update(BootUser bootUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(String id);

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    int count();
}


