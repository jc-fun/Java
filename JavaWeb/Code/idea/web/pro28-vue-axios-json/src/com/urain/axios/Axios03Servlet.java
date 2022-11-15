package com.urain.axios;


import com.google.gson.Gson;
import com.urain.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author: urain
 * @date: 2022/4/19 13:42
 * @description:
 * @version: 1.0
 */
@WebServlet("/axios03.do")
public class Axios03Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuffer = new StringBuilder();
        BufferedReader bufferedReader = req.getReader();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            stringBuffer.append(str);
        }
        bufferedReader.close();
        str = stringBuffer.toString();

        Gson gson = new Gson();
        User user = gson.fromJson(str, User.class);
        user.setUname("孙悟空");
        user.setPwd("123456");

        // 使用toJson方法将java对象转化为json字符串
        String userJsonStr = gson.toJson(user);
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(userJsonStr);
    }
}
