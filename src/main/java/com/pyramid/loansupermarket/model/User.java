package com.pyramid.loansupermarket.model;

import javax.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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


    @OneToMany(mappedBy = "users")
    private Set<Demand> demands = new HashSet<>();


    @CreatedDate
    private Date createTime;

    @LastModifiedDate
    private Date updateTime;


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

    public Set<Demand> getDemands() {
        return demands;
    }

    public void setDemands(Set<Demand> demands) {
        this.demands = demands;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }



}
