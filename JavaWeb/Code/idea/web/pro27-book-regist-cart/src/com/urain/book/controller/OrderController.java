package com.urain.book.controller;

import com.urain.book.pojo.OrderBean;
import com.urain.book.pojo.User;
import com.urain.book.service.OrderService;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author: urain
 * @date: 2022/4/17 18:10
 * @description:
 * @version: 1.0
 */
public class OrderController {
    private OrderService orderService;
    // 结账
    public String checkout(HttpSession session) {
        OrderBean orderBean = new OrderBean();
//        Date date = new Date();
//        int year = date.getYear();
//        int month = date.getMonth();
//        int day = date.getDate();
//        int hour = date.getHours();
//        int min = date.getMinutes();
//        int sec = date.getSeconds();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String nowStr = dtf.format(now);
        orderBean.setOrderNo(UUID.randomUUID().toString() + "_" + nowStr);
        orderBean.setOrderDate(now);
        User user = (User) session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);

        orderService.addOrderBean(orderBean);

        return "index";
    }

    // 查看订单列表
    public String getOrderList(HttpSession session) {
        User user = (User) session.getAttribute("currUser");

        List<OrderBean> orderList = orderService.getOrderList(user);
        user.setOrderList(orderList);
        session.setAttribute("currUser", user);

        return "order/order";
    }
}
