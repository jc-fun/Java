package com.urain.dubbo.service.impl;

import com.urain.dubbo.model.User;
import com.urain.dubbo.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Package: com.urain.dubbo.service.impl
 * @Author: urain
 * @Date: 2022/8/22 22:39
 * @Version: 1.0.0
 * @Description: TODO
 */
public class UserServiceImpl implements UserService {


    @Override
    public User queryUserById(Integer id, String username) {

        User user = new User();
        user.setId(id);
        user.setUsername(username + "-1");
        return user;
    }
}
