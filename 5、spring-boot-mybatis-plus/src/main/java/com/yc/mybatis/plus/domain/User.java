package com.yc.mybatis.plus.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.jvm.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author: yangc
 * @Description: TODO
 * @Date: Created in 17:34 2023/5/6
 *
 */
@Data
@TableName(value = "yc_user")
public class User implements Serializable {

    private static final long serialVersionUID = -339516038496531943L;
    /**
     * 用户ID
     */
    @TableId ( value = "id" )
    private String id;

    /**
     * 地址
     */
    @TableField ( "address" )
    private String address;

    /**
     * 账号
     */
    private String accountNumber;

    /**
     * 密码
     */
    private String password;

    /**
     * 类型
     */
    private String type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date creatTime;

    /**
     * 修改时间
     */
    private Date updateTime;

}
