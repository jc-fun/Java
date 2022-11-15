package com.urain.book.pojo;

/**
 * @Author: supertain
 * @Date: 2022/4/16 17:29
 * @Description:
 */
public class OrderItem {
    private Integer id;
    private Book book;
    private Integer buyCount;
    private OrderBean orderbean;

    public OrderItem() {}

    public OrderItem(Integer id) {
        this.id = id;
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

    public OrderBean getOrderbean() {
        return orderbean;
    }

    public void setOrderbean(OrderBean orderbean) {
        this.orderbean = orderbean;
    }
}
