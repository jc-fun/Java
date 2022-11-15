package com.urain.spring5.service;

import com.urain.spring5.User;
import com.urain.spring5.dao.UserDAO;
import com.urain.spring5.dao.impl.UserDAOImpl;

/**
 * @author: urain
 * @date: 2022/4/23 12:31
 * @description:
 * @version: 1.0
 */
public class UserService {

    // 创建UserDAO类型的属性，并生成set方法
    private UserDAO userDAO;

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void add() {
        System.out.println("Service add......");

//        // 原始方式：创建UserDAO对象
//        UserDAO userDAO = new UserDAOImpl();
//        userDAO.update();
        userDAO.update();


    }
}
