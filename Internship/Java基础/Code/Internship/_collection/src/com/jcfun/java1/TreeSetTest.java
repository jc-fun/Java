package com.jcfun.java1;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: TreeSetTest
 * @Package: com.jcfun.java1
 * @Author: jcfun
 * @Date: 2022/11/4 16:00
 * @Version: 1.0.0
 * @Description: TODO
 */
public class TreeSetTest {

    @Test
    public void test1() {
        TreeSet treeSet = new TreeSet();
        // 不能添加不同类的对象
        // treeSet.add(123);
        // treeSet.add(456);
        // treeSet.add("AA");
        // treeSet.add(false);
        // treeSet.add(new Person("Tom", 18));


        // treeSet.add(12);
        // treeSet.add(-34);
        // treeSet.add(56);
        // treeSet.add(43);


        treeSet.add(new User("Tom", 16));
        treeSet.add(new User("Jerry", 13));
        treeSet.add(new User("Marry", 45));
        treeSet.add(new User("Jack", 23));
        treeSet.add(new User("Jim", 34));
        treeSet.add(new User("Jim", 43));


        // ints.add(3);
        // Arrays.toString(arr);
        // System.out.println(arr.toString());

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }


    @Test
    public void test2() {
        Comparator com = new Comparator() {
            // 按照年龄从小到大排列
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User) {
                    User u1 = (User) o1;
                    User u2 = (User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                } else {
                    throw new RuntimeException("输入数据类型不匹配");
                }
            }
        };

        var treeSet = new TreeSet(com);
        treeSet.add(new User("Tom", 16));
        treeSet.add(new User("Jerry", 13));
        treeSet.add(new User("Marry", 45));
        treeSet.add(new User("Jack", 23));
        treeSet.add(new User("Jim", 34));
        treeSet.add(new User("Jim", 43));

        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }


}
