package com.urain.cookies.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: urain
 * @date: 2022/4/18 12:22
 * @description:
 * @version: 1.0
 */
@WebServlet("/kaptcha01")
public class KaptchaServletDemo01 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object kaptcha_session_key_obj = session.getAttribute("KAPTCHA_SESSION_KEY");
        System.out.println("kaptcha_session_key_obj = " + kaptcha_session_key_obj);


    }
}
