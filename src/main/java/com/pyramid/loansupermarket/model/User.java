package com.pyramid.loansupermarket.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//表结构实体类
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //自动递增id
    private int id;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name="real_name")
    private String realName;

    @Column(name="IDNumber")
    private String idNumber;


    @OneToMany(cascade = {CascadeType.PERSIST})
    private List<Demand> demands;  //一对多关联，多表在Demand


    @CreatedDate
    @JsonFormat(timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")    //插入时自动创建时间
    private Long createTime;

    @LastModifiedDate
    @JsonFormat(timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //最后一次更新自动更新时间
    private Long updateTime;


    //赋值方法
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {

        this.password = password;
    }
    public void setPhoneNumber(String phoneNumber){

        this.phoneNumber= phoneNumber;
    }

    public void setRealName(String realName){
        this.realName=realName;
    }
    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }


    //取值方法
    public Integer getId() {

        return id;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getRealName(){
        return realName;
    }
    public String getIdNumber(){
        return idNumber;
    }

    //传递一对多对象关联
    public List<Demand> getDemands() {
        return demands;
    }

    public void setDemands(List<Demand> demands) {
        this.demands = demands;
    }


    public Long getCreateTime() {
        return createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }



}
