package com.pyramid.loansupermarket.modelRepository;

import com.pyramid.loansupermarket.model.Demand;
import com.pyramid.loansupermarket.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface DemandRepository extends JpaRepository<Demand, Integer> {


}