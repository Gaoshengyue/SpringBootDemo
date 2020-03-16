package com.pyramid.loansupermarket.user;


import com.alibaba.fastjson.JSONObject;
import com.pyramid.loansupermarket.model.User;
import com.pyramid.loansupermarket.modelRegistry.UserRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@ResponseBody
@RequestMapping("/user")
public class UserAdmin {
    @Autowired
    private UserRegistry respository;

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public List<User> dataList(){

        return respository.findAll();
    }


    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    public User InsertUser(@RequestBody JSONObject jsonObject){
        System.out.println(jsonObject.toJSONString());
        User userObj=new User();
        userObj.setUsername(jsonObject.get("username").toString());
        userObj.setPassword(jsonObject.get("password").toString());

        return respository.save(userObj);
    }
}
