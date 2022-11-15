package com.urain.book.dao;

import com.urain.book.pojo.User;

/**
 * @Author: supertain
 * @Date: 2022/4/16 17:46
 * @Description:
 */
public interface UserDAO {
    User getUser(String uname, String pwd);
    void addUser(User user);
    User getUser(String uname);
}
