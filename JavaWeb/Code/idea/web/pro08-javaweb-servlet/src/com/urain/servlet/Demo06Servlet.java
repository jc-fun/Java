package com.urain.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: supertain
 * @Date: 2022/4/7 9:07
 * @Description:
 */

// 演示服务器端内部转发，以及客户端重定向
public class Demo06Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo06......");
//        req.getRequestDispatcher("demo07").forward(req, resp);
        resp.sendRedirect("demo07");
    }
}
