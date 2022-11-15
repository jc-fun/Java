package com.urain.fruit.servlets;

import com.urain.fruit.dao.FruitDAO;
import com.urain.fruit.dao.impl.FruitDAOImpl;
import com.urain.fruit.pojo.Fruit;
import com.urain.myssm.myspringmvc.ViewBaseServlet;
import com.urain.myssm.util.StringUtil;
import javassist.compiler.ast.Keyword;

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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();

        int pageNo = 1;

        String oper = req.getParameter("oper");

        String keyword = null;
        if(StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            pageNo = 1;
            keyword = req.getParameter("keyword");
            if(StringUtil.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            String pageNoStr = req.getParameter("pageNo");
            if (StringUtil.isNotEmpty(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            Object keywordObj = session.getAttribute("keyword");
            if(keywordObj != null) {
                keyword = (String) keywordObj;
            } else {
                keyword = "";
            }
        }
        session.setAttribute("pageNo", pageNo);

        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList(keyword, pageNo);

        // 总记录数
        long fruitCount = fruitDAO.getFruitCount(keyword);
        // 总页数
        long pageCount = (fruitCount / 5) + 1;
        session.setAttribute("pageCount", pageCount);

        // 保存到session作用域
        session.setAttribute("fruitList", fruitList);

        super.processTemplate("index", req, resp);
    }
}
