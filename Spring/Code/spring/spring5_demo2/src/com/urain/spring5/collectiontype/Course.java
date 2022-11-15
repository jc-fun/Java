package com.urain.spring5.collectiontype;

/**
 * @author: urain
 * @date: 2022/4/23 16:33
 * @description:
 * @version: 1.0
 */
public class Course {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
            "cname='" + cname + '\'' +
            '}';
    }
}
