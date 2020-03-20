package com.pyramid.loansupermarket.ServiceRepository;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pyramid.loansupermarket.model.Demand;
import com.pyramid.loansupermarket.model.User;
import com.pyramid.loansupermarket.status.DemandResultStatus;
import com.pyramid.loansupermarket.status.UserResultStatus;
import org.springframework.stereotype.Repository;
//Demand需求接口定义
@Repository("demandServiceRepository")
public interface DemandServiceRepository {

    DemandResultStatus createDemand(JSONObject jsonObject);
    Demand createDemandObj(JSONObject jsonObject);
    User getUserObj(JSONObject jsonObject);

}
