package com.yc.data.jpa.service.impl;

import com.yc.data.jpa.entity.BootUser;
import com.yc.data.jpa.repo.BootUserRepo;
import com.yc.data.jpa.service.BootUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (BootUser)表服务实现类
 *
 * @author yangc
 * @since 2024-04-29 14:32:44
 */
@Service ( "bootUserService" )
public class BootUserServiceImpl implements BootUserService {
    @Resource
    private BootUserRepo bootUserRepo;

    @Override
    public BootUser queryById(String id) {
        return this.bootUserRepo.getById(id);
    }

    @Override
    public List<BootUser> getAllInfo() {
        return this.bootUserRepo.findAll();

    }

    public Page<BootUser> queryAllByLimit(int pageNumber, int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("id").descending());
        return bootUserRepo.findAll(pageable);
    }

    @Override
    public BootUser insert(BootUser bootUser) {
        bootUser.setAge(1);
        //生产随机数
        bootUser.setName("小明"+Math.random());
        bootUser.setPassword(String.valueOf(Math.random()));
        bootUser.setCreateTime(new Date());
        return this.bootUserRepo.save(bootUser);
    }


    @Override
    public BootUser update(BootUser bootUser) {
        bootUser.setAge(1);
        //生成随机数
        bootUser.setName("小王"+Math.random());
        bootUser.setPassword(String.valueOf(Math.random()));
        bootUser.setCreateTime(new Date());
        return this.bootUserRepo.saveAndFlush(bootUser);
    }


    @Override
    public boolean deleteById(String id) {

        try {
            this.bootUserRepo.deleteById(id);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }
}

