package com.urain.spring5.bean;

/**
 * @author: urain
 * @date: 2022/4/23 14:41
 * @description:
 * @version: 1.0
 */
public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
            "dname='" + dname + '\'' +
            '}';
    }
}
