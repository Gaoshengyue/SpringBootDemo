package com.pyramid.loansupermarket.user;


import com.alibaba.fastjson.JSONObject;
import com.pyramid.loansupermarket.model.User;
import com.pyramid.loansupermarket.modelRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ResponseBody
@RequestMapping("/user")
public class UserAdmin {
    @Autowired
    private UserRepository respository;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public List<User> dataList() {

        return respository.findAll();
    }


    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public User InsertUser(@RequestBody JSONObject jsonObject) {
        System.out.println(jsonObject.toJSONString());
        User userObj = new User();
        userObj.setUsername(jsonObject.getString("username"));
        userObj.setPassword(jsonObject.getString("password"));
        userObj.setPhoneNumber(jsonObject.getString("phoneNumber"));
        userObj.setIdNumber(jsonObject.getString("idNumber"));
        userObj.setRealName(jsonObject.getString("realName"));

        return respository.save(userObj);
    }
}
