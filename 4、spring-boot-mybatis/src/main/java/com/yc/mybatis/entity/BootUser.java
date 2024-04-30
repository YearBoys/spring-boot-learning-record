package com.yc.mybatis.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * (BootUser)实体类
 *
 * @author yangc
 * @since 2024-04-28 17:42:17
 */
public class BootUser implements Serializable {
    private static final long serialVersionUID = -92819414316896000L;
    /**
     * 主键
     */
    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 备注
     */
    private String remark;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "BootUser {" +
                "id : " + id + ", " +
                "name : " + name + ", " +
                "password : " + password + ", " +
                "age : " + age + ", " +
                "createTime : " + createTime + ", " +
                "remark : " + remark + ", " +
                '}';
    }
}


