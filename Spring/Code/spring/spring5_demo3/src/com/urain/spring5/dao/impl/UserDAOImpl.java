package com.urain.spring5.dao.impl;

import com.urain.spring5.dao.UserDAO;
import org.springframework.stereotype.Repository;

/**
 * @author: urain
 * @date: 2022/4/23 23:09
 * @description:
 * @version: 1.0
 */
@Repository(value = "userDAOImpl1")
public class UserDAOImpl implements UserDAO {
    @Override
    public void add() {
        System.out.println("dao add......");
    }
}
