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


@RestController   //Rest风格控制器，注意与Controller不能同时使用，此风格控制器无法使用模板
@ResponseBody    //转换对象，json格式
@RequestMapping("/examine")
public class ExamineApi {

    @Autowired  //注入数据操作接口
    private DemandRepository demandRepository;

    @RequestMapping(value = "/demand", method = RequestMethod.GET)
    public List<Demand> demandList() {
        return demandRepository.findAll();
    }

    @Autowired //注入业务操作接口
    private DemandServiceRepository demandServiceRepository;
    @RequestMapping(value = "/demand", method = RequestMethod.POST)
    public DemandResultStatus InsertUser(@RequestBody JSONObject jsonObject) { //JSONOBject为阿里解析库
        DemandResultStatus demandResultStatus;
        demandResultStatus=demandServiceRepository.createDemand(jsonObject);
        return demandResultStatus;
    }

}
