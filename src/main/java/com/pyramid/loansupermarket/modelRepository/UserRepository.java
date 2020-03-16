package com.pyramid.loansupermarket.modelRepository;
import com.pyramid.loansupermarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {


}