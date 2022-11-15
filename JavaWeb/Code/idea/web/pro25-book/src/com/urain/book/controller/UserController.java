package com.urain.book.controller;

import com.urain.book.pojo.Cart;
import com.urain.book.pojo.User;
import com.urain.book.service.CartItemService;
import com.urain.book.service.UserService;

import javax.servlet.http.HttpSession;

/**
 * @author: urain
 * @date: 2022/4/16 18:19
 * @description:
 * @version: 1.0
*/

public class UserController {
    private UserService userService;
    private CartItemService cartItemService;

    public String login(String uname, String pwd, HttpSession session) {

        User user = userService.login(uname, pwd);

        if(user != null) {
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser", user);
            return "redirect:book.do";
        }
        return "user/login";
    }
}

