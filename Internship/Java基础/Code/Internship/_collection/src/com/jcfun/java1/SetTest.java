package com.jcfun.java1;

import com.jcfun.java.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ClassName: SetTest
 * @Package: com.jcfun.java1
 * @Author: jcfun
 * @Date: 2022/11/4 14:27
 * @Version: 1.0.0
 * @Description: TODO
 */
public class SetTest {

    @Test
    public void test1() {
        Set set = new HashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 18));
        set.add(true);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test12() {
        Set set = new LinkedHashSet();
        set.add(456);
        set.add(123);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom", 18));
        set.add(true);

        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }



}
