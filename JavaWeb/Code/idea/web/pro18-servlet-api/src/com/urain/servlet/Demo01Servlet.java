package com.urain.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: supertain
 * @Date: 2022/4/10 10:23
 * @Description:
 */

/*
@WebServlet(
    urlPatterns = {"/demo01"},
    initParams = {
        @WebInitParam(name = "hello", value = "world"),
        @WebInitParam(name = "uname", value = "Tom")
    }
)
*/
public class Demo01Servlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        String initValue = config.getInitParameter("hello");
        //System.out.println("initValue = " + initValue);
        ServletContext context = getServletContext();
        String contextConfigLocation = context.getInitParameter("contextConfigLocation");
        System.out.println(contextConfigLocation);

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getServletContext();
//        req.getSession().getServletContext();

    }

}
