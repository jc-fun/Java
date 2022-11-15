package com.urain.book.dao.impl;

import com.urain.book.dao.OrderDAO;
import com.urain.book.pojo.OrderBean;
import com.urain.book.pojo.User;
import com.urain.myssm.basedao.BaseDAO;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 16:12
 * @description:
 * @version: 1.0
 */
public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {
    @Override
    public void addOrderBean(OrderBean orderBean) {
        int orderBeanId = executeUpdate("insert into t_order values(0, ?, ?, ?, ?, ?)", orderBean.getOrderNo(), orderBean.getOrderDate(), orderBean.getOrderUser().getId(), orderBean.getOrderMoney(), orderBean.getOrderStatus());
        orderBean.setId(orderBeanId);
        // 此处为什么要接收execute的返回值，然后设置到OrderBean中的id属性上？
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        return executeQuery("select * from t_order where orderUser = ?", user.getId());
    }

    @Override
    public Integer getOrderTotalBookCount(OrderBean orderBean) {
        String sql = "SELECT SUM(buyCount) AS totalBookCount, orderBean " +
            "FROM" +
            "    (" +
            "      SELECT t1.id, t2.buyCount, t2.orderBean " +
            "      FROM t_order t1 JOIN t_order_item t2" +
            "      ON t1.`id` = t2.orderBean " +
            "      WHERE t1.`orderUser` = ?" +
            "    ) t3 " +
            "WHERE orderBean = ? " +
            "GROUP BY orderBean";
        return ((BigDecimal)executeComplexQuery(sql, orderBean.getOrderUser().getId(), orderBean.getId())[0]).intValue();
    }
}
