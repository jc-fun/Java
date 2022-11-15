package com.urain.fruit.servlets;

import com.urain.fruit.dao.FruitDAO;
import com.urain.fruit.dao.impl.FruitDAOImpl;
import com.urain.fruit.pojo.Fruit;
import com.urain.myssm.myspringmvc.ViewBaseServlet;
import com.urain.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/7 9:59
 * @Description:
 */

// Servlet从3.0开始支持注解方式的注册
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = 1;
        String pageNoStr = req.getParameter("pageNo");
        if (StringUtil.isNotEmpty(pageNoStr)) {
            pageNo = Integer.parseInt(pageNoStr);
        }

        HttpSession session = req.getSession();
        session.setAttribute("pageNo", pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(pageNo);

        // 总记录数
        long fruitCount = fruitDAO.getFruitCount();
        // 总页数
        long pageCount = (fruitCount / 5) + 1;
        session.setAttribute("pageCount", pageCount);

        // 保存到session作用域
        session.setAttribute("fruitList", fruitList);

        super.processTemplate("index", req, resp);
    }
}
