package com.jcfun.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ListTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/4 10:51
 * @Version: 1.0.0
 * @Description: TODO
 */
public class ListTest {

    @Test
    public void test1() {

        var list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("Tom", 16));
        list.add(false);


        System.out.println(list);

        // add
        list.add(1, "BB");

        // addAll
        List list1 = Arrays.asList(789, 456);
        list.addAll(list1);
        System.out.println(list);

        // get
        System.out.println(list.get(1));

        // indexOf
        System.out.println(list.indexOf("BB"));

        // lastIndexOf
        System.out.println(list.lastIndexOf(456));

        // remove
        Object obj = list.remove(1);
        System.out.println(obj);

        // set
        list.set(1, "CC");
        System.out.println(list);

        // subList
        List sublist = list.subList(0, 4);
        System.out.println(sublist);
        System.out.println(list);


    }



}
