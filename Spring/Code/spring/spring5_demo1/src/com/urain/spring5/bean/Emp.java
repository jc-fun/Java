package com.urain.spring5.bean;

/**
 * @author: urain
 * @date: 2022/4/23 14:42
 * @description:
 * @version: 1.0
 */
public class Emp {
    private String ename;
    private String gender;
    // 员工属于某一个部门，使用对象形式表示
    private Dept dept;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDept(Dept dept) {
        System.out.println("setDept");
        this.dept = dept;
    }

    public Dept getDept() {
        System.out.println("dept = " + dept);
        System.out.println("getDept");
        return dept;
    }

    public void add() {
        System.out.println(ename + "::" + gender + "::" + dept);
    }
}
