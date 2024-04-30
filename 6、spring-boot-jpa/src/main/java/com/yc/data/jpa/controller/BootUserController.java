package com.yc.data.jpa.controller;

import com.yc.data.jpa.entity.BootUser;
import com.yc.data.jpa.service.BootUserService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BootUser)表控制层
 *
 * @author yangc
 * @since 2024-04-29 14:32:43
 */
@RestController
@RequestMapping ( "bootUser" )
public class BootUserController {


    /**
     * 服务对象
     */
    @Resource
    private BootUserService bootUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping ( "selectOne/{id}" )
    public ResponseEntity<BootUser> selectOne(@PathVariable ( value = "id" ) String id) {
        // 返回单条数据
        return ResponseEntity.ok(this.bootUserService.queryById(id));
    }


    /**
     * 获取全部
     *
     * @return
     */
    @GetMapping ( "selectAll" )
    public ResponseEntity<List<BootUser>> selectALl() {
        return ResponseEntity.ok(this.bootUserService.getAllInfo());
    }


    /**
     * 获取分页列表
     *
     * @return
     */
    @GetMapping ( "queryAllByLimit" )
    public ResponseEntity<Page<BootUser>> queryAllByLimit() {
        return ResponseEntity.ok(this.bootUserService.queryAllByLimit(0, 10));
    }


    /**
     * 修改
     *
     * @param bootUser
     * @return
     */

    @PutMapping
    public ResponseEntity<BootUser> update(@RequestBody BootUser bootUser) {
        return ResponseEntity.ok(this.bootUserService.update(bootUser));
    }

    /**
     * 新增
     *
     * @param bootUser
     * @return
     */
    @PostMapping
    public ResponseEntity<BootUser> insert(@RequestBody BootUser bootUser) {
        return ResponseEntity.ok(this.bootUserService.insert(bootUser));
    }

}

