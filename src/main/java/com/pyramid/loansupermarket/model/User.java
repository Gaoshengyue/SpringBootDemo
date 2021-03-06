package com.pyramid.loansupermarket.model;

import javax.persistence.*;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Set;

//表结构实体类
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

    @Column(name="ID_number")
    private String idNumber;

    @JsonIgnore //忽略此属性，用于多表关联
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)  //关联属性
    @JoinColumn(name = "user_id",referencedColumnName ="id" ) //关联id 反查id
    private Set<Demand> demands;  //一对多关联，多表在Demand


    @CreatedDate
    private String createTime;

    @LastModifiedDate
    private String updateTime;


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
    public int getId() {

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
    @JsonIgnore
    public Set<Demand> getDemands() {
        return demands;
    }

    public void setDemands(Set<Demand> demands) {
        this.demands = demands;
    }


    public String getCreateTime() {
        return createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }



}
