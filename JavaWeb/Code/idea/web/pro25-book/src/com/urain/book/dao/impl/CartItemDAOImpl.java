package com.urain.book.dao.impl;

import com.urain.book.dao.CartItemDAO;
import com.urain.book.pojo.CartItem;
import com.urain.book.pojo.User;
import com.urain.myssm.basedao.BaseDAO;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/17 10:45
 * @description:
 * @version: 1.0
 */
public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {

    @Override
    public void addCartItem(CartItem cartItem) {
        executeUpdate("insert into t_cart_item values(0, ?, ?, ?)", cartItem.getBook().getId(), cartItem.getBuyCount(), cartItem.getUserBean().getId());
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        executeUpdate("update t_cart_item set buyCount = ? where id = ?", cartItem.getBuyCount(), cartItem.getId());
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        return executeQuery("select * from t_cart_item where userBean = ?", user.getId());
    }

    @Override
    public void delCartItem(CartItem cartItem) {
        executeUpdate("delete from t_cart_item where id = ?", cartItem.getId());
    }
}
