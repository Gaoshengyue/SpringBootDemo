package com.pyramid.loansupermarket.model;
import javax.persistence.*;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;
    @Column(name="username")
    private String username;

    @Column(name = "password")
    private String password;

    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){

        this.password=password;
    }
    public Integer getId(){

        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

}


