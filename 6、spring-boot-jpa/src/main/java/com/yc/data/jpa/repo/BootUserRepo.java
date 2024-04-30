package com.yc.data.jpa.repo;

import com.yc.data.jpa.entity.BootUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * (BootUser)表数据库访问层
 *
 * @author zry
 * @since 2024-04-29 14:32:44
 */
public interface BootUserRepo extends JpaRepository<BootUser, String> {


}

