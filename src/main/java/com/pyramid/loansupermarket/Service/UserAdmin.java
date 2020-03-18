package com.pyramid.loansupermarket.Service;

import com.alibaba.fastjson.JSONObject;
import com.pyramid.loansupermarket.ServiceRepository.UserAdminRepository;
import com.pyramid.loansupermarket.messageLib.UserInsertFaieldMessage;
import com.pyramid.loansupermarket.messageLib.UserInsertSucessMessage;
import com.pyramid.loansupermarket.model.User;
import com.pyramid.loansupermarket.modelRepository.UserRepository;
import com.pyramid.loansupermarket.status.UserResultStatus;
import org.hibernate.dialect.SybaseAnywhereDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAdmin implements UserAdminRepository {

    @Autowired
    private UserRepository respository;

    public UserResultStatus register(JSONObject jsonObject) {
        UserResultStatus rs_obj = new UserResultStatus();
        User user_obj;
        user_obj = createUserObj(jsonObject);
        List<User> user_list;
        user_list = getUser(user_obj);
        if (user_list.size() <= 0) {
            UserInsertSucessMessage message_obj = new UserInsertSucessMessage();
            rs_obj.setUser(respository.save(user_obj));
            rs_obj.setMessage(message_obj.message);
            rs_obj.setStatusCode(message_obj.code);
        } else {
            UserInsertFaieldMessage message_obj = new UserInsertFaieldMessage();
            rs_obj.setMessage(message_obj.message);
            rs_obj.setStatusCode(message_obj.code);
        }
        return rs_obj;
    }


    //用户操作方法
    public User createUserObj(JSONObject jsonObject) {
        User userObj = new User();
        userObj.setUsername(jsonObject.getString("username"));
        userObj.setPassword(jsonObject.getString("password"));
        userObj.setPhoneNumber(jsonObject.getString("phoneNumber"));
        userObj.setIdNumber(jsonObject.getString("idNumber"));
        userObj.setRealName(jsonObject.getString("realName"));
        return userObj;
    }

    public List<User> getUser(User user_obj) {
        List<User> user_list;
        user_list = respository.findUser(user_obj.getUsername(), user_obj.getRealName(), user_obj.getPhoneNumber(), user_obj.getIdNumber());
        return user_list;
    }


}
