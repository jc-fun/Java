package com.urain.servlet;

import com.urain.fruit.dao.impl.FruitDAOImpl;
import com.urain.fruit.pojo.Fruit;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @Author: supertain
 * @Date: 2022/4/5 18:48
 * @Description:
 */
public class AddServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        Integer price = Integer.parseInt(priceStr);
        String fcountStr = req.getParameter("fcount");
        Integer fcount = Integer.parseInt(fcountStr);
        String remark = req.getParameter("remark");

        FruitDAOImpl fruitDAO = new FruitDAOImpl();
        boolean flag = fruitDAO.addFruit(new Fruit(0, fname, price, fcount, remark));
        System.out.println(flag ? "添加成功" : "添加失败");



    }
}
