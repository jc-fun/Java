package com.urain.dubbo.service.impl;

import com.urain.dubbo.model.User;
import com.urain.dubbo.service.UserService;

/**
 * @ClassName: UserServiceImpl
 * @Package: com.urain.dubbo.service.impl
 * @Author: urain
 * @Date: 2022/8/17 21:55
 * @Version: 1.0.0
 * @Description: TODO
 */
public class UserServiceImpl implements UserService {
    @Override
    public User queryUserById(Integer id) {

        User user = new User();
        user.setId(id);
        user.setUsername("张三");

        return user;
    }

    @Override
    public Integer queryAllUserCount() {
        return 52;
    }
}
