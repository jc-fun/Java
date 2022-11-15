package com.urain.book.dao;

import com.urain.book.pojo.CartItem;
import com.urain.book.pojo.User;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 10:42
 * @description:
 * @version: 1.0
 */
public interface CartItemDAO {
    // 新增购物车项
    void addCartItem(CartItem cartItem);
    // 修改特定的购物车项
    void updateCartItem(CartItem cartItem);
    // 获取特定用户的所有购物车项
    List<CartItem> getCartItemList(User user);
    // 删除指定的购物车项
    void delCartItem(CartItem cartItem);
}
