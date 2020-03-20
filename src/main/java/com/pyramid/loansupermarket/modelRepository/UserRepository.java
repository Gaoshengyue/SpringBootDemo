package com.pyramid.loansupermarket.modelRepository;

import com.pyramid.loansupermarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
//用户数据接口定义
public interface UserRepository extends JpaRepository<User, Integer> {
    //sql编写，数据操作编写，可扩展
    @Query(value = "select * from user where username= :username or real_name= :real_name or phone_number= :phone_number or id_number= :id_number", nativeQuery = true)
    List<User> findUser(@Param("username") String username, @Param("real_name") String real_name, @Param("phone_number") String phone_number, @Param("id_number") String id_number);

    @Query(value = "select * from user where id = :id", nativeQuery = true)
    User findOneUserById(@Param("id") Integer id);

}