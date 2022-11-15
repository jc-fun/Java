package com.urain.book.service;

import com.urain.book.pojo.Cart;
import com.urain.book.pojo.CartItem;
import com.urain.book.pojo.User;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 10:52
 * @description:
 * @version: 1.0
 */
public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);
    // 获取指定用户的所有购物车项列表
    List<CartItem> getCartItemsList(User user);
    // 加载特定用户的购物车信息
    Cart getCart(User user);
}
