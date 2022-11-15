package com.urain.book.service.impl;

import com.urain.book.dao.UserDAO;
import com.urain.book.pojo.User;
import com.urain.book.service.UserService;

/**
 * @Author: supertain
 * @Date: 2022/4/16 17:53
 * @Description:
 */
public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname, pwd);
    }
}
