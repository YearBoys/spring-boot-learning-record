package com.yc.data.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * (BootUser)实体类
 *
 * @author yangc
 * @since 2024-04-29 14:32:44
 */
@Entity
@Table ( name = "boot_user" )
//表示忽略hibernateLazyInitializer这个属性，那么也就不会出现为空的情况了。
@JsonIgnoreProperties (value = {"hibernateLazyInitializer"})
public class BootUser   implements Serializable {
    private static final long serialVersionUID = -82527045137988087L;
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "system-id")
    @GenericGenerator(name = "system-id", strategy = "com.yc.data.jpa.util.CustomIDGenerator")
    private String id;




    /**
     * 姓名
     */
    @Column ( name = "name", nullable = false )
    private String name;
    /**
     * 密码
     */
    @Column ( name = "password", nullable = false )
    private String password;
    /**
     * 年龄
     */
    @Column ( name = "age", nullable = false )
    private Integer age;
    /**
     * 创建时间
     */
    @Column ( name = "createTime", nullable = false )
    @JsonFormat (pattern="yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    /**
     * 备注
     */
    @Column ( name = "remark", nullable = false )
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

}

