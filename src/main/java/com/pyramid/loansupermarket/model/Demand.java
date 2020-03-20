package com.pyramid.loansupermarket.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "demand")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;

    @Column(name = "money")
    private float money;

    @Lob  //自动将字符串转换成长文本
    @Column(name = "reason")
    private String reason;

    @JsonIgnore
    @ManyToOne(cascade ={CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private User users;

    @CreatedDate
    private String createtime;

    @LastModifiedDate
    private String updatetime;

    public String getReason() {
        return reason;
    }

    public String getCreatetime() {
        return createtime;
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public float getMoney() {
        return money;
    }


    public void setMoney(float money) {
        this.money = money;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public void setUsers(User users) {
        this.users = users;
    }

    @JsonIgnore
    public User getUsers() {
        return users;
    }

    public int getDid() {
        return did;
    }

}
