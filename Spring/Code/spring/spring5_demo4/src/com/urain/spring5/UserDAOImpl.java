package com.urain.spring5;

/**
 * @author: urain
 * @date: 2022/4/24 10:51
 * @description:
 * @version: 1.0
 */
public class UserDAOImpl implements UserDAO{

    @Override
    public int add(int a, int b) {
        System.out.println("add方法执行了......");
        return a + b;
    }

    @Override
    public String update(String id) {
        System.out.println("update方法执行了......");
        return id;
    }
}
