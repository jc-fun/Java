package com.urain.spring5.autowire;

/**
 * @author: urain
 * @date: 2022/4/23 18:27
 * @description:
 * @version: 1.0
 */
public class Emp {
    private Dept dept;

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
            "dept=" + dept +
            '}';
    }

    public void test() {
        System.out.println(dept);
    }
}
