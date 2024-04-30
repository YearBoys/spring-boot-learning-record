package com.yc.data.jpa.service;

import com.yc.data.jpa.entity.BootUser;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * (BootUser)表服务接口
 *
 * @author zry
 * @since 2024-04-29 14:32:44
 */
public interface BootUserService {
    BootUser queryById(String id);

    Page<BootUser> queryAllByLimit(int offset, int limit);

    BootUser insert(BootUser bootUser);

    BootUser update(BootUser bootUser);

    boolean deleteById(String id);

    List<BootUser> getAllInfo();
}

