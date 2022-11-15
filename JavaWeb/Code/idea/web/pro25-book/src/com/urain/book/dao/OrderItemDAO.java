package com.urain.book.dao;

import com.urain.book.pojo.OrderItem;

/**
 * @author: urain
 * @date: 2022/4/17 16:09
 * @description:
 * @version: 1.0
 */
public interface OrderItemDAO {
    // 添加订单项
    void addOrderItem(OrderItem orderItem);
}
