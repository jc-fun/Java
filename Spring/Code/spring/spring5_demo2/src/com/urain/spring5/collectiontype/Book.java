package com.urain.spring5.collectiontype;

import java.util.List;

/**
 * @author: urain
 * @date: 2022/4/23 16:42
 * @description:
 * @version: 1.0
 */
public class Book {
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void test() {
        System.out.println(list);
    }
}
