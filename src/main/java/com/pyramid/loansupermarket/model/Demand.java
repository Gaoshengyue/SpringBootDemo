package com.pyramid.loansupermarket.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "demand")
public class Demand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int did;

    @Column(name = "money")
    private float money;

    @Lob
    @Column(name = "reason")
    private String reason;

    @ManyToOne(cascade ={CascadeType.MERGE,CascadeType.REFRESH} )
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

    public User getUsers() {
        return users;
    }

    public int getDid() {
        return did;
    }

}
