package com.urain.book.dao;

import com.urain.book.pojo.OrderBean;
import com.urain.book.pojo.User;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 16:08
 * @description:
 * @version: 1.0
 */
public interface OrderDAO {
    // 添加订单
    void addOrderBean(OrderBean orderBean);

    // 获取指定用户的订单列表
    List<OrderBean> getOrderList(User user);

    Integer getOrderTotalBookCount(OrderBean orderBean);
}
