package com.urain.fruit.controllers;

import com.urain.fruit.pojo.Fruit;
import com.urain.fruit.service.FruitService;
import com.urain.myssm.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: supertain
 * @Date: 2022/4/8 23:08
 * @Description:
 */
public class FruitController {

    private FruitService fruitService = null;

    private String index(String oper, String keyword, Integer pageNo, HttpServletRequest req) {
        HttpSession session = req.getSession();

        if(pageNo == null) {
            pageNo = 1;
        }
        if (StringUtil.isNotEmpty(oper) && "search".equals(oper)) {
            pageNo = 1;
            if (StringUtil.isEmpty(keyword)) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
        } else {
            Object keywordObj = session.getAttribute("keyword");
            if (keywordObj != null) {
                keyword = (String) keywordObj;
            } else {
                keyword = "";
            }
        }
        session.setAttribute("pageNo", pageNo);

        List<Fruit> fruitList = fruitService.getFruitList(keyword, pageNo);
        // 保存到session作用域
        session.setAttribute("fruitList", fruitList);

        // 总记录数
        long pageCount = fruitService.getPageCount(keyword);
        // 总页数
        session.setAttribute("pageCount", pageCount);

        // super.processTemplate("index", req, resp);
        return "index";
    }

    private String add(String fname, Integer price, Integer fcount, String remark) {
        Fruit fruit = new Fruit(0, fname, price, fcount, remark);
        fruitService.addFruit(fruit);
        return "redirect:fruit.do";
    }


    private String del(Integer fid) {
        if (fid != null) {
            fruitService.delFruit(fid);
            // resp.sendRedirect("fruit.do");
            return "redirect:fruit.do";
        }
        return "error";
    }


    private String edit(Integer fid, HttpServletRequest req) {
        if (fid != null) {
            Fruit fruit = fruitService.getFruitByFid(fid);
            req.setAttribute("fruit", fruit);
            // super.processTemplate("edit", req, resp);
            return "edit";
        }
        return "error";
    }


    private String update(Integer fid, String fname, Integer price, Integer fcount, String remark) {
        // 3.执行更新
        Fruit fruit = new Fruit(fid, fname, price, fcount, remark);
        fruitService.updateFruit(fruit);

        // 4.资源跳转
        // resp.sendRedirect("fruit.do");
        return "redirect:fruit.do";
    }
}
