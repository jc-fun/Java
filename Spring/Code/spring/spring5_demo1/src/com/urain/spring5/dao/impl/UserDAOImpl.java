package com.urain.spring5.dao.impl;

import com.urain.spring5.dao.UserDAO;

/**
 * @author: urain
 * @date: 2022/4/23 12:32
 * @description:
 * @version: 1.0
 */
public class UserDAOImpl implements UserDAO {

    @Override
    public void update() {
        System.out.println("dao update......");
    }
}
