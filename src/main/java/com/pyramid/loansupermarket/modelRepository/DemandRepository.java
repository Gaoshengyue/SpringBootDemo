package com.pyramid.loansupermarket.modelRepository;

import com.pyramid.loansupermarket.model.Demand;
import org.springframework.data.jpa.repository.JpaRepository;

//Demand数据接口定义

public interface DemandRepository extends JpaRepository<Demand, Integer> {


}