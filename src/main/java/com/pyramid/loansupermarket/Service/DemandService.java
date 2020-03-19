package com.pyramid.loansupermarket.Service;


import com.alibaba.fastjson.JSONObject;
import com.pyramid.loansupermarket.ServiceRepository.DemandServiceRepository;
import com.pyramid.loansupermarket.ServiceRepository.UserAdminRepository;
import com.pyramid.loansupermarket.messageLib.DemandSuccessMessage;
import com.pyramid.loansupermarket.model.Demand;
import com.pyramid.loansupermarket.model.User;
import com.pyramid.loansupermarket.modelRepository.DemandRepository;
import com.pyramid.loansupermarket.modelRepository.UserRepository;
import com.pyramid.loansupermarket.status.DemandResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DemandService implements DemandServiceRepository {

    @Autowired
    private DemandRepository demandRepository;

    @Autowired
    private UserRepository userRepository;


    public DemandResultStatus createDemand(JSONObject jsonObject){
        DemandResultStatus demandResultStatus=new DemandResultStatus();
        DemandSuccessMessage demandSuccessMessage =new DemandSuccessMessage();
        Demand demand;
        demand=createDemandObj(jsonObject);
        System.out.println(demand);

        demandResultStatus.setDemand(demand);
        demandResultStatus.setMessage(demandSuccessMessage.message);
        demandResultStatus.setStatusCode(demandSuccessMessage.code);
        return demandResultStatus;
    }

    public Demand createDemandObj(JSONObject jsonObject){
        Demand demand = new Demand();
        User user;
        user=userRepository.findOneUserById(jsonObject.getIntValue("user_id"));
        System.out.println(user);
        demand.setMoney(jsonObject.getFloat("Money"));
        demand.setReason(jsonObject.getString("Reason"));
        user.getDemands().add(demand);
        userRepository.save(user);
//        demand.setUsers(user);
        demand=demandRepository.save(demand);
        return demand;
    }

}
