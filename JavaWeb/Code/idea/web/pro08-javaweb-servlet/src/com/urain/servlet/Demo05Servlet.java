package com.urain.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: supertain
 * @Date: 2022/4/7 8:26
 * @Description:
 */

// 演示从HttpSession保存作用域中获取数据
public class Demo05Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object uname = req.getSession().getAttribute("uname");
        System.out.println(uname);
    }
}
