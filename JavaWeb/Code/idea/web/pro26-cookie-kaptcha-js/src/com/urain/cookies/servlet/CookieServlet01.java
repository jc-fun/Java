package com.urain.cookies.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: urain
 * @date: 2022/4/18 10:36
 * @description:
 * @version: 1.0
 */

@WebServlet("/cookie01")
public class CookieServlet01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.创建一个Cookie对象
        Cookie cookie = new Cookie("uname", "jim");
        // 2.将Cookie对象保存到浏览器端
        resp.addCookie(cookie);
        req.getRequestDispatcher("hello01.html").forward(req, resp);
    }
}
