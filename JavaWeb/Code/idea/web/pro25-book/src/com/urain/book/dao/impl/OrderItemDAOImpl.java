package com.urain.book.dao.impl;

import com.urain.book.dao.OrderItemDAO;
import com.urain.book.pojo.OrderItem;
import com.urain.myssm.basedao.BaseDAO;

/**
 * @author: urain
 * @date: 2022/4/17 16:34
 * @description:
 * @version: 1.0
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
        executeUpdate("insert into t_order_item values(0, ?, ?, ?)", orderItem.getBook().getId(), orderItem.getBuyCount(), orderItem.getOrderbean().getId());
    }
}
