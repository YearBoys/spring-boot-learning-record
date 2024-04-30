package com.yc.mybatis.service.impl;

import com.yc.mybatis.entity.BootUser;
import com.yc.mybatis.dao.BootUserDao;
import com.yc.mybatis.service.BootUserService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * (BootUser表)服务实现类
 *
 * @author yangc
 * @since 2024-04-28 17:42:17
 */
@Service ( "bootUserService" )
public class BootUserServiceImpl implements BootUserService {
    @Resource
    private BootUserDao bootUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BootUser selectById(String id) {
        return this.bootUserDao.selectById(id);
    }

    /**
     * 查询所有
     *
     * @return 实例对象的集合
     */
    @Override
    public List<BootUser> selectAll() {
        return this.bootUserDao.selectAll();
    }

    /**
     * 根据条件查询
     *
     * @return 实例对象的集合
     */
    @Override
    public List<BootUser> selectList(BootUser bootUser) {
        return this.bootUserDao.selectList(bootUser);
    }

    /**
     * 新增数据
     *
     * @param bootUser 实例对象
     * @return 实例对象
     */
    @Override
    public int insert(BootUser bootUser) {
        return this.bootUserDao.insert(bootUser);
    }

    /**
     * 批量新增
     *
     * @param bootUsers 实例对象的集合
     * @return 生效的条数
     */
    @Override
    public int batchInsert(List<BootUser> bootUsers) {
        return this.bootUserDao.batchInsert(bootUsers);
    }

    /**
     * 修改数据
     *
     * @param bootUser 实例对象
     * @return 实例对象
     */
    @Override
    public BootUser update(BootUser bootUser) {
        this.bootUserDao.update(bootUser);
        return this.selectById(bootUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public int deleteById(String id) {
        return this.bootUserDao.deleteById(id);
    }

    /**
     * 查询总数据数
     *
     * @return 数据总数
     */
    @Override
    public int count() {
        return this.bootUserDao.count();
    }
}


