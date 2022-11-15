package com.urain.book.service.impl;

import com.urain.book.dao.CartItemDAO;
import com.urain.book.pojo.Book;
import com.urain.book.pojo.Cart;
import com.urain.book.pojo.CartItem;
import com.urain.book.pojo.User;
import com.urain.book.service.BookService;
import com.urain.book.service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: urain
 * @date: 2022/4/17 10:54
 * @description:
 * @version: 1.0
 */
public class CartItemServiceImpl implements CartItemService {

    private CartItemDAO cartItemDAO;
    private BookService bookService;

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        // 1.如果当前用户的购物车中已经存在这个图书了，那么将购物车中这本图书的数量+1
        // 2.否则，在我的购物车中新增一个这本图书的CartItem，数量是1
        if (cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap == null) {
                cartItemMap = new HashMap<>();
            }
            if (cartItemMap.containsKey(cartItem.getBook().getId())) {
                CartItem cartItemTemp = cartItemMap.get(cartItem.getBook().getId());
                cartItemTemp.setBuyCount(cartItemTemp.getBuyCount() + 1);
                updateCartItem(cartItemTemp);
            } else {
                addCartItem(cartItem);
            }
        } else {
            addCartItem(cartItem);
        }
        // 判断当前用户的购物车中是否有这本书的CartItem，有则update，无则add
    }

    @Override
    public List<CartItem> getCartItemsList(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);
        for(CartItem cartItem : cartItemList) {
            Book book = bookService.getBook(cartItem.getBook().getId());
            cartItem.setBook(book);
        }
        return cartItemList;
    }

    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList = getCartItemsList(user);
        Map<Integer, CartItem> cartItemMap = new HashMap<>();
        for(CartItem cartItem : cartItemList) {
            cartItemMap.put(cartItem.getBook().getId(), cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        return cart;
    }
}
