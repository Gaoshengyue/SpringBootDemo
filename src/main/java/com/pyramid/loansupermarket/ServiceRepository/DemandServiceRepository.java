package com.pyramid.loansupermarket.ServiceRepository;


import com.alibaba.fastjson.JSONObject;
import com.pyramid.loansupermarket.model.Demand;
import com.pyramid.loansupermarket.status.DemandResultStatus;
import com.pyramid.loansupermarket.status.UserResultStatus;
import org.springframework.stereotype.Repository;

@Repository("demandServiceRepository")
public interface DemandServiceRepository {

    DemandResultStatus createDemand(JSONObject jsonObject);
    Demand createDemandObj(JSONObject jsonObject);

}
