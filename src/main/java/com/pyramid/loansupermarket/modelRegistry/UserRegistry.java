package com.pyramid.loansupermarket.modelRegistry;
import com.pyramid.loansupermarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRegistry extends JpaRepository<User,Integer> {


}