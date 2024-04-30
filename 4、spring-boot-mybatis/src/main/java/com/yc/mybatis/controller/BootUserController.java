package com.yc.mybatis.controller;

import com.yc.mybatis.common.R;
import com.yc.mybatis.entity.BootUser;
import com.yc.mybatis.service.BootUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.annotation.Resource;

/**
 * (BootUser)控制层
 *
 * @author yangc
 * @since 2024-04-28 17:42:17
 */
@RestController
@RequestMapping ( "/bootUser" )
public class BootUserController {
    /**
     * 服务对象
     */
    @Resource
    private BootUserService bootUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param bootUser 参数对象
     * @return 单条数据
     */
    @RequestMapping ( value = "get", method = RequestMethod.GET )
    public R<BootUser> selectOne(BootUser bootUser) {
        BootUser result = bootUserService.selectById(bootUser.getId());
        if (result != null) {
            return R.success(result);
        }
        return R.error();
    }

    /**
     * 新增一条数据
     *
     * @param bootUser 实体类
     * @return Response对象
     */
    @RequestMapping ( value = "insert", method = RequestMethod.POST )
    public R<BootUser> insert(@RequestBody BootUser bootUser) {
        int result = bootUserService.insert(bootUser);
        if (result > 0) {
            return R.success();
        }
        return R.error();
    }

    /**
     * 修改一条数据
     *
     * @param bootUser 实体类
     * @return Response对象
     */
    @RequestMapping ( value = "update", method = RequestMethod.PUT )
    public R<BootUser> update(@RequestBody BootUser bootUser) {
        BootUser result = bootUserService.update(bootUser);
        if (result != null) {
            return R.success(result);
        }
        return R.error();
    }

    /**
     * 删除一条数据
     *
     * @param bootUser 参数对象
     * @return Response对象
     */
    @RequestMapping ( value = "delete", method = RequestMethod.DELETE )
    public R<BootUser> delete(BootUser bootUser) {
        int result = bootUserService.deleteById(bootUser.getId());
        if (result > 0) {
            return R.success();
        }
        return R.error();
    }

    /**
     * 查询全部
     *
     * @return Response对象
     */
    @RequestMapping ( value = "selectAll", method = RequestMethod.GET )
    public R<List<BootUser>> selectAll() {
        List<BootUser> bootUsers = bootUserService.selectAll();
        if (bootUsers != null) {
            return R.success(bootUsers);
        }
        return R.error();
    }

//    /**
//     * 分页查询
//     *
//     * @param start 偏移
//     * @param limit 条数
//     * @return Response对象
//     */
//    @RequestMapping ( value = "selectPage", method = RequestMethod.GET )
//    public R<PageResult> selectPage(Integer start, Integer limit) {
//        PageResult pageResult = bootUserService.selectPage(start, limit);
//        if (pageResult != null) {
//            return R.success(pageResult);
//        }
//        return R.GET_FAIL();
//    }

}


