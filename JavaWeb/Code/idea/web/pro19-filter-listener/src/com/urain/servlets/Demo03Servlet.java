package com.urain.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: supertain
 * @Date: 2022/4/10 15:39
 * @Description:
 */
@WebServlet("/demo03.do")
public class Demo03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("demo03 service.....");
        req.getRequestDispatcher("succ.html").forward(req, resp);
    }
}
