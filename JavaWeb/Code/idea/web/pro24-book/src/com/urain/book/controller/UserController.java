package com.urain.book.controller;

import com.urain.book.pojo.User;
import com.urain.book.service.UserService;

/**
 * @author: urain
 * @date: 2022/4/16 18:19
 * @description:
 * @version: 1.0
*/

public class UserController {
    private UserService userService;

    public String login(String uname, String pwd) {

        User user = userService.login(uname, pwd);

        System.out.println(user);
        return "index";
    }
}

