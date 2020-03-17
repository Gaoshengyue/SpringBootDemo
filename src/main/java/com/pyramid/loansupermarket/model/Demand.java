package com.pyramid.loansupermarket.model;

import javax.persistence.*;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "demand")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;

    @Column(name = "money")
    private Float money;

    @Lob
    @Column(name = "reason")
    private String reason;

    @ManyToOne(cascade =CascadeType.PERSIST )
    @JoinColumn(name="user_id")
    private User users;



    @CreatedDate
    private Date createtime;

    @LastModifiedDate
    private Date updatetime;

    public String getReason() {
        return reason;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public Float getMoney() {
        return money;
    }


    public void setMoney(Float money) {
        this.money = money;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


    public void setUsers(User users) {
        this.users = users;
    }

    public User getUsers() {
        return users;
    }

    public int getDid() {
        return did;
    }

}
