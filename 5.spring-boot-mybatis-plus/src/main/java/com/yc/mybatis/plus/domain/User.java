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
 * @TableName属性:
 * value	String	否	""	表名
 * schema	String	否	""	schema
 * keepGlobalPrefix	boolean	否	false	是否保持使用全局的 tablePrefix 的值（当全局 tablePrefix 生效时）
 * resultMap	String	否	""	xml 中 resultMap 的 id（用于满足特定类型的实体类对象绑定）
 * autoResultMap	boolean	否	false	是否自动构建 resultMap 并使用（如果设置 resultMap 则不会进行 resultMap 的自动构建与注入）
 * excludeProperty	String[]	否	{}	需要排除的属性名 @since 3.3.1
 *
 */
@Data
@TableName(value = "yc_user")
public class User implements Serializable {

    private static final long serialVersionUID = -339516038496531943L;
    /**
     * 用户ID
     *  @TableId ：
     * value	String	否	""	主键字段名
     * type	Enum	否	IdType.NONE	指定主键类型
     *   IdType:
     *       AUTO	数据库 ID 自增
     *       NONE	无状态，该类型为未设置主键类型（注解里等于跟随全局，全局里约等于 INPUT）
     *       INPUT	insert 前自行 set 主键值
     *       ASSIGN_ID	分配 ID(主键类型为 Number(Long 和 Integer)或 String)(since 3.3.0),使用接口IdentifierGenerator的方法nextId(默认实现类为DefaultIdentifierGenerator雪花算法)
     *       ASSIGN_UUID	分配 UUID,主键类型为 String(since 3.3.0),使用接口IdentifierGenerator的方法nextUUID(默认 default 方法)
     *       ID_WORKER	分布式全局唯一 ID 长整型类型(please use ASSIGN_ID)
     *       UUID	32 位 UUID 字符串(please use ASSIGN_UUID)
     *       ID_WORKER_STR	分布式全局唯一 ID 字符串类型(please use ASSIGN_ID)
     */
    @TableId(value = "id")
    private Integer id;

    /**
     * 地址
     * @TableField 描述：
     *    字段注解（非主键）
     *    属性	类型	必须指定	默认值	描述
     * value	String	否	""	数据库字段名
     * exist	boolean	否	true	是否为数据库表字段
     * condition	String	否	""	字段 where 实体查询比较条件，有值设置则按设置的值为准，没有则为默认全局的 %s=#{%s}，参考(opens new window)
     * update	String	否	""	字段 update set 部分注入，例如：当在version字段上注解update="%s+1" 表示更新时会 set version=version+1 （该属性优先级高于 el 属性）
     * insertStrategy	Enum	否	FieldStrategy.DEFAULT	举例：NOT_NULL
     * insert into table_a(<if test="columnProperty != null">column</if>) values (<if test="columnProperty != null">#{columnProperty}</if>)
     * updateStrategy	Enum	否	FieldStrategy.DEFAULT	举例：IGNORED
     * update table_a set column=#{columnProperty}
     * whereStrategy	Enum	否	FieldStrategy.DEFAULT	举例：NOT_EMPTY
     * where <if test="columnProperty != null and columnProperty!=''">column=#{columnProperty}</if>
     * fill	Enum	否	FieldFill.DEFAULT	字段自动填充策略
     * select	boolean	否	true	是否进行 select 查询
     * keepGlobalFormat	boolean	否	false	是否保持使用全局的 format 进行处理
     * jdbcType	JdbcType	否	JdbcType.UNDEFINED	JDBC 类型 (该默认值不代表会按照该值生效)
     * typeHandler	Class<? extends TypeHandler>	否	UnknownTypeHandler.class	类型处理器 (该默认值不代表会按照该值生效)
     * numericScale	String	否	""	指定小数点后保留的位数
     */
    @TableField("address")
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

//    @Transient
//    @TableField 逻辑删除
//    private boolean enabled;
}
