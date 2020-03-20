package com.pyramid.loansupermarket.Service;


import com.alibaba.fastjson.JSONObject;
import com.pyramid.loansupermarket.ServiceRepository.DemandServiceRepository;
import com.pyramid.loansupermarket.ServiceRepository.UserAdminRepository;
import com.pyramid.loansupermarket.messageLib.DemandFaieldMessage;
import com.pyramid.loansupermarket.messageLib.DemandSuccessMessage;
import com.pyramid.loansupermarket.model.Demand;
import com.pyramid.loansupermarket.model.User;
import com.pyramid.loansupermarket.modelRepository.DemandRepository;
import com.pyramid.loansupermarket.modelRepository.UserRepository;
import com.pyramid.loansupermarket.status.DemandResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.Optional;

//Demand需求接口实体
@Service //定义接口类型
public class DemandService implements DemandServiceRepository {

    @Autowired  //注入数据接口操作
    private DemandRepository demandRepository;

    @Autowired
    private UserRepository userRepository;


    public DemandResultStatus createDemand(JSONObject jsonObject){
        DemandResultStatus demandResultStatus=new DemandResultStatus();
        Demand demand;
        User user;
        user=getUserObj(jsonObject);
        if (user!=null){
            DemandSuccessMessage demandSuccessMessage =new DemandSuccessMessage();
            demand=createDemandObj(jsonObject,user);
            demand=demandRepository.save(demand);
            demandResultStatus.setDemand(demand);
            demandResultStatus.setMessage(demandSuccessMessage.message);
            demandResultStatus.setStatusCode(demandSuccessMessage.code);
        }else{
            DemandFaieldMessage demandFaieldMessage = new DemandFaieldMessage();
            demandResultStatus.setMessage(demandFaieldMessage.message);
            demandResultStatus.setStatusCode(demandFaieldMessage.code);
        }
        return demandResultStatus;
    }

    @Override //重载，重写父类
    public Demand createDemandObj(JSONObject jsonObject) {
        return null;
    }

    public User getUserObj(JSONObject jsonObject){
        User user;
        user=userRepository.findOneUserById(jsonObject.getIntValue("user_id"));
        return user;

    }

    public Demand createDemandObj(JSONObject jsonObject,User user){
        Demand demand = new Demand();
        demand.setMoney(jsonObject.getFloat("Money"));
        demand.setReason(jsonObject.getString("Reason"));
        demand.setUsers(user);
        return demand;
    }

}
