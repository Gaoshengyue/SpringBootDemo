package com.pyramid.loansupermarket.ApiLib;


import com.alibaba.fastjson.JSONObject;
import com.pyramid.loansupermarket.ServiceRepository.DemandServiceRepository;
import com.pyramid.loansupermarket.model.Demand;
import com.pyramid.loansupermarket.model.User;
import com.pyramid.loansupermarket.modelRepository.DemandRepository;
import com.pyramid.loansupermarket.status.DemandResultStatus;
import com.pyramid.loansupermarket.status.UserResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/examine")
public class ExamineApi {

    @Autowired
    private DemandRepository demandRepository;

    @RequestMapping(value = "/demand", method = RequestMethod.GET)
    public List<Demand> demandList() {
        return demandRepository.findAll();
    }

    @Autowired
    private DemandServiceRepository demandServiceRepository;
    @RequestMapping(value = "/demand", method = RequestMethod.POST)
    public DemandResultStatus InsertUser(@RequestBody JSONObject jsonObject) {
        DemandResultStatus demandResultStatus;
        demandResultStatus=demandServiceRepository.createDemand(jsonObject);
        return demandResultStatus;
    }

}
