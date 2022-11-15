package com.urain.dubbo.service.impl;

import com.urain.dubbo.model.User;
import com.urain.dubbo.service.UserService;

/**
 * @Author: urain
 * @Date: 2022/8/13 19:04
 * @Description:
 * @Version: 1.0
 */
public class UserServiceImpl implements UserService {

    @Override
    public User queryUserById(Integer id) {
        var user = new User();
        user.setId(id);
        user.setUsername("张三");
        user.setAge(18);
        return user;
    }

}
