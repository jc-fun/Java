package com.urain.spring5;

/**
 * @author: urain
 * @date: 2022/4/23 11:00
 * @description: 使用有参构造器进行属性注入
 * @version: 1.0
 */
public class Orders {
    private String oname;
    private String address;
    private Book obook;

    public Orders(String oname, String address, Book obook) {
        this.oname = oname;
        this.address = address;
        this.obook = obook;
        System.out.println("Orders");
    }

    public void ordersTest() {
        System.out.println("oname = " + oname);
        System.out.println("address = " + address);
        System.out.println("obook = " + obook);
    }
}
