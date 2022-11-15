package com.urain.book.service.impl;

import com.urain.book.dao.CartItemDAO;
import com.urain.book.dao.OrderDAO;
import com.urain.book.dao.OrderItemDAO;
import com.urain.book.pojo.CartItem;
import com.urain.book.pojo.OrderBean;
import com.urain.book.pojo.OrderItem;
import com.urain.book.pojo.User;
import com.urain.book.service.OrderService;

import java.util.List;
import java.util.Map;

/**
 * @author: urain
 * @date: 2022/4/17 16:46
 * @description:
 * @version: 1.0
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;

    @Override
    public void addOrderBean(OrderBean orderBean) {
        // 1.订单表添加一条记录
        // 2.订单详情表添加7条记录
        // 3.购物车项表中需要删除对应的7条记录
        // 第1步
        orderDAO.addOrderBean(orderBean); // 执行完这一步，orderBean中的id是有值的
        // 第2步
        // orderBean中的orderItemList是空的，此处我们应该根据用户的购物车中的购物车项去转换成一个一个的订单项
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for(CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderbean(orderBean);
            orderItemDAO.addOrderItem(orderItem);
        }
        // 第3步
        for(CartItem cartItem : cartItemMap.values()) {
            cartItemDAO.delCartItem(cartItem);
        }
    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        List<OrderBean> orderBeanList = orderDAO.getOrderList(user);
        for(OrderBean orderBean : orderBeanList) {
            Integer totalBookCount = orderDAO.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }
        return orderBeanList;
    }
}
