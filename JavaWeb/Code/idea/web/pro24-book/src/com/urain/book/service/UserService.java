package com.urain.book.service;

import com.urain.book.pojo.User;

/**
 * @Author: supertain
 * @Date: 2022/4/16 17:50
 * @Description:
 */
public interface UserService {
    User login(String uname, String pwd);
}
