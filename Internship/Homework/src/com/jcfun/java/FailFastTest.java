package com.jcfun.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @ClassName: FailFastTest
 * @Package: com.jcfun.java
 * @Author: urain
 * @Date: 2022/11/7 下午10:26
 * @Version: 1.0.0
 * @Description: TODO
 */
public class FailFastTest {

    @Test
    public void test1() {


        var list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(789);
        list.add("list");

        try {
            list.stream().forEach(item -> {
                    list.add(12345);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Test
    public void test2() {

        var list = new ArrayList<>();
        list.add(123);
        list.add(456);
        list.add(789);
        list.add("list");

        Iterator<Object> iterator = list.iterator();
        try {
            while (iterator.hasNext()) {
                Object next = iterator.next();
                if ("list".equals(next)) {
                    // list.remove("list");
                    list.add("add");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }





}
