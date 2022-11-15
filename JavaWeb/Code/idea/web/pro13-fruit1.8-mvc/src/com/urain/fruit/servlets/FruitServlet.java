package com.urain.fruit.servlets;

import com.urain.fruit.dao.FruitDAO;
import com.urain.fruit.dao.impl.FruitDAOImpl;
import com.urain.fruit.pojo.Fruit;
import com.urain.myssm.myspringmvc.ViewBaseServlet;
import com.urain.myssm.util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/8 23:08
 * @Description:
 */
@WebServlet("/fruit.do")
public class FruitServlet extends ViewBaseServlet {

    private FruitDAO fruitDAO = new FruitDAOImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        String operate = req.getParameter("operate");
        if(StringUtil.isEmpty(operate)) {
            operate = "index";
        }

        switch (operate) {
            case "index":
                index(req, resp);
                break;
            case "add":
                add(req, resp);
                break;
            case "del":
                del(req, resp);
                break;
            case "edit":
                edit(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            default:
                throw new RuntimeException("operate value is illegal");
        }
    }


    private void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fname = req.getParameter("fname");
        int price = Integer.parseInt(req.getParameter("price"));
        int fcount = Integer.parseInt(req.getParameter("fcount"));
        String remark = req.getParameter("remark");
        Fruit fruit = new Fruit(0, fname, price, fcount, remark);
        fruitDAO.addFruit(fruit);

        resp.sendRedirect("fruit.do");
    }


    private void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        if(StringUtil.isNotEmpty(fidStr)) {
            int fid = Integer.parseInt(fidStr);
            fruitDAO.delFruit(fid);
            resp.sendRedirect("fruit.do");
        }
    }


    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fidStr = req.getParameter("fid");
        if(StringUtil.isNotEmpty(fidStr)) {
            int fid = Integer.parseInt(fidStr);
            Fruit fruit = fruitDAO.getFruitByFid(fid);
            req.setAttribute("fruit", fruit);
            super.processTemplate("edit", req, resp);
        }
    }


    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.设置编码
//        req.setCharacterEncoding("utf-8");

        // 2.获取参数
        String fidStr = req.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        String fname = req.getParameter("fname");
        String priceStr = req.getParameter("price");
        int price = Integer.parseInt(priceStr);
        String fcountStr = req.getParameter("fcount");
        int fcount = Integer.parseInt(fcountStr);
        String remark = req.getParameter("remark");
        // 3.执行更新
        Fruit fruit = new Fruit(fid, fname, price, fcount, remark);
        fruitDAO.updateFruit(fruit);

        // 4.资源跳转
        //super.processTemplate("index", req, resp);
        // req.getRequestDispatcher("index.html").forward(req, resp);
        //此处需要重定向，目的是重新给IndexServlet发请求，重新获取furitList，然后覆盖到session中，这样index.html页面上显示的session中的数据才是最新的
        resp.sendRedirect("fruit.do");
    }
}
