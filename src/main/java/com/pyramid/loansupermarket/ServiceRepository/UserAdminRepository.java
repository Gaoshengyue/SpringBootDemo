package com.pyramid.loansupermarket.ServiceRepository;

import com.alibaba.fastjson.JSONObject;
import com.pyramid.loansupermarket.model.User;
import com.pyramid.loansupermarket.status.UserResultStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
// UserAdmin用户管理接口定义
@Repository("userAdminRepository")
public interface UserAdminRepository {

    UserResultStatus register(JSONObject jsonObject);

    User createUserObj(JSONObject jsonObject);

    List<User> getUser(User user_obj);

}
