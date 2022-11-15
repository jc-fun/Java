package com.jcfun.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName: IteratorTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/4 9:00
 * @Version: 1.0.0
 * @Description: TODO
 */
public class IteratorTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jerry", 18));

        Iterator iterator = coll.iterator();
        // for (int i = 0; i < coll.size(); i++) {
        //     System.out.println(iterator.next());
        // }

        // while(iterator.hasNext()) {
        //     System.out.println(iterator.next());
        // }

        // iterator.remove()
        while(iterator.hasNext()) {
            Object obj = iterator.next();
            if("Tom".equals(obj)) {
                iterator.remove();
            }
        }
        iterator = coll.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }


}
