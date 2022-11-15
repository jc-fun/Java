package com.jcfun.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @ClassName: ForTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/4 9:24
 * @Version: 1.0.0
 * @Description: TODO
 */
public class ForTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jerry", 18));
        for (Object o : coll) {
            System.out.println(o);
        }

        int[] arr = new int[] {1, 2, 3, 4, 5};
        for (int i : arr) {
            System.out.println(i);
        }


    }


}
