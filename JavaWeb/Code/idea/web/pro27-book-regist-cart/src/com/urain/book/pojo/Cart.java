package com.urain.book.pojo;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;

/**
 * @author: urain
 * @date: 2022/4/17 10:57
 * @description:
 * @version: 1.0
 */
public class Cart {
    private Map<Integer, CartItem> cartItemMap; // 购物车中购物车项的集合，这个Map集合中的key是Book的id
    private Double totalMoney; // 购物车的总金额
    private Integer totalCount; // 购物车中购物项的数量
    private Integer totalBookCount; // 购物车中书本的总数量

    public Cart() {
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {
        totalMoney = 0.0;
        if (cartItemMap != null && cartItemMap.size() > 0) {
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> entry : entries) {
                CartItem cartItem = entry.getValue();
                totalMoney = new BigDecimal(cartItem.getXj() + "").add(new BigDecimal(totalMoney + "")).doubleValue();
//                BigDecimal bigDecimalPrice = new BigDecimal(cartItem.getBook().getPrice() + "");
//                BigDecimal bigDecimalBuyCount = new BigDecimal(cartItem.getBuyCount() + "");
//                Double totalMoneyTemp = bigDecimalPrice.multiply(bigDecimalBuyCount).doubleValue();
//                totalMoney = totalMoney + totalMoneyTemp;
            }
        }
        return totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;
        if(cartItemMap != null && cartItemMap.size() > 0) {
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }

    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if(cartItemMap != null && cartItemMap.size() > 0) {
            for(CartItem cartItem : cartItemMap.values()) {
                totalBookCount = totalBookCount + cartItem.getBuyCount();
            }
        }
        return totalBookCount;
    }
}
