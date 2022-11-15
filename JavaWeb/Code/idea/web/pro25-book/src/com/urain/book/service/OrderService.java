package com.urain.book.service;

import com.urain.book.pojo.OrderBean;
import com.urain.book.pojo.User;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 16:40
 * @description:
 * @version: 1.0
 */
public interface OrderService {
    void addOrderBean(OrderBean orderBean);

    List<OrderBean> getOrderList(User user);
}
