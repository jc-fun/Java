package com.urain.book.controller;

import com.urain.book.pojo.Cart;
import com.urain.book.pojo.User;
import com.urain.book.service.CartItemService;
import com.urain.book.service.UserService;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

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

        if (user != null) {
            Cart cart = cartItemService.getCart(user);
            user.setCart(cart);
            session.setAttribute("currUser", user);
            return "redirect:book.do";
        }
        return "user/login";
    }

    public String regist(String verifyCode, String uname, String pwd, String email, HttpSession session, HttpServletResponse resp) throws IOException {
        Object kaptchaCode = session.getAttribute("KAPTCHA_SESSION_KEY");
        if (!verifyCode.equals(kaptchaCode)) {
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out = resp.getWriter();
            out.println("<script lang='javascript'>alert('验证码不正确');</script>");
            return "user/regist";
        } else {
            userService.regist((new User(uname, pwd, email, 0)));
            return "user/login";
        }
    }

    public String ckUname(String uname) {
        User user = userService.getUser(uname);
        if (user != null) {
            // 用户名已被占用，不可以注册
            return "json:{'uname':'1'}";
            //return "ajax:1";
        } else {
            return "json:{'uname':'0'}";
            //return "ajax:0";
        }
    }
}

