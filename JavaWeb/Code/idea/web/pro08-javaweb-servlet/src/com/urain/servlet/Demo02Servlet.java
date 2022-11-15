package com.urain.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: supertain
 * @Date: 2022/4/6 18:10
 * @Description:
 */

// 演示Servlet的生命周期
public class Demo02Servlet extends HttpServlet {

    public Demo02Servlet() {
        System.out.println("正在实例化......");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("正在初始化......");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("正在服务......");
    }

    @Override
    public void destroy() {
        System.out.println("正在销毁......");
    }
}
