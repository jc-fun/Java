package com.urain.book.pojo;

import java.math.BigDecimal;

/**
 * @Author: supertain
 * @Date: 2022/4/16 17:31
 * @Description:
 */
public class CartItem {
    private Integer id;
    private Book book;
    private Integer buyCount;
    private User userBean;
    private Double xj = 0.0;

    public CartItem() {}

    public CartItem(Book book, Integer buyCount, User userBean) {
        this.book = book;
        this.buyCount = buyCount;
        this.userBean = userBean;
    }

    public CartItem(Integer id) {
        this.id = id;
    }

    public CartItem(Integer id, Integer buyCount) {
        this.id = id;
        this.buyCount = buyCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public User getUserBean() {
        return userBean;
    }

    public void setUserBean(User userBean) {
        this.userBean = userBean;
    }

    public Double getXj() {
        BigDecimal bigDecimalPrice = new BigDecimal(getBook().getPrice() + "");
        BigDecimal bigDecimalBuyCount = new BigDecimal(buyCount + "");
        BigDecimal bigDecimalXJ = bigDecimalPrice.multiply(bigDecimalBuyCount);
        xj = bigDecimalXJ.doubleValue();
        return xj;
    }
}
