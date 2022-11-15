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
import java.io.PrintWriter;

/**
 * @author: urain
 * @date: 2022/4/19 13:42
 * @description:
 * @version: 1.0
 */
@WebServlet("/axios02.do")
public class Axios02Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder stringBuffer = new StringBuilder("");
        BufferedReader bufferedReader = req.getReader();
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            stringBuffer.append(str);
        }
        bufferedReader.close();
        str = stringBuffer.toString();

        Gson gson = new Gson();
        User user = gson.fromJson(str, User.class);
        System.out.println(user);
    }
}
