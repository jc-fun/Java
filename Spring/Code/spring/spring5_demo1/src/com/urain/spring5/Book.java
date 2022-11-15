package com.urain.spring5;

/**
 * @author: urain
 * @date: 2022/4/23 10:42
 * @description: 使用set方法进行属性注入
 * @version: 1.0
 */
public class Book {
    private String bname;
    private User bauthor;
    private String description;

    // 创建属性对应的set方法
    public void setBname(String bname) {
        this.bname = bname;
//        System.out.println("setBname");
    }

    public void setBauthor(User bauthor) {
        this.bauthor = bauthor;
//        System.out.println("setBauthor");
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void testDemo() {
        System.out.println("bname = " + bname);
        System.out.println("bauthor = " + bauthor);
        System.out.println("description = " + description);
    }

}
