package com.urain.book.controller;

import com.urain.book.pojo.Book;
import com.urain.book.pojo.Cart;
import com.urain.book.pojo.CartItem;
import com.urain.book.pojo.User;
import com.urain.book.service.CartItemService;

import javax.servlet.http.HttpSession;

/**
 * @author: urain
 * @date: 2022/4/17 10:38
 * @description:
 * @version: 1.0
 */
public class CartController {
    private CartItemService cartItemService;

    // 加载当前用户的购物车信息
    public String index(HttpSession session) {
        User user = (User)session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser", user);
        return "cart/cart";
    }

    public String addCart(Integer bookId, HttpSession session) {
        User user = (User)session.getAttribute("currUser");
        CartItem cartItem = new CartItem(new Book(bookId), 1, user);

        // 将指定的图书添加到当前用户的购物车中
        cartItemService.addOrUpdateCartItem(cartItem, user.getCart());
        return "redirect:cart.do";
    }

    public String editCart(Integer cartItemId, Integer buyCount) {
        CartItem cartItem = new CartItem(cartItemId, buyCount);
        cartItemService.updateCartItem(cartItem);

        return "redirect:cart.do";
    }
}
