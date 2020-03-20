package com.pyramid.loansupermarket.ApiLib;


import com.alibaba.fastjson.JSONObject;
import com.pyramid.loansupermarket.ServiceRepository.UserAdminRepository;
import com.pyramid.loansupermarket.model.User;
import com.pyramid.loansupermarket.modelRepository.UserRepository;
import com.pyramid.loansupermarket.status.UserResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ResponseBody
@RequestMapping("/user")
public class UserApi {
    @Autowired
    private UserRepository respository;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public List<User> userList() {
        return respository.findAll();
    }

    @Autowired
    private UserAdminRepository userAdminRepository;
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public UserResultStatus InsertUser(@RequestBody JSONObject jsonObject) {
        UserResultStatus userResultStatus;
        userResultStatus=userAdminRepository.register(jsonObject);
        return userResultStatus;
    }
}
