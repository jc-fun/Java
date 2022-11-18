package com.jcfun.java2;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: TreeMapTest
 * @Package: com.jcfun.java2
 * @Author: urain
 * @Date: 2022/11/18 上午8:51
 * @Version: 1.0.0
 * @Description: TODO
 */
public class TreeMapTest {


    // 自然排序
    @Test
    public void test() {
        TreeMap treeMap = new TreeMap();
        User user1 = new User("Tom", 23);
        User user2 = new User("Jerry", 12);
        User user3 = new User("Jack", 53);
        User user4 = new User("Jim", 34);
        User user5 = new User("Rose", 18);


        treeMap.put(user1, 78);
        treeMap.put(user2, 67);
        treeMap.put(user3, 34);
        treeMap.put(user4, 89);
        treeMap.put(user5, 79);


        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + " --> " +entry.getValue());
        }

    }


    // 定制排序
    @Test
    public void test1() {
        TreeMap treeMap = new TreeMap((o1, o2) -> {
            if (o1 instanceof User && o2 instanceof User) {
                User u1 = (User) o1;
                User u2 = (User) o2;
                return Integer.compare(u1.getAge(), u2.getAge());
            }
            throw new RuntimeException("输入的类型不匹配");
        });
        User user1 = new User("Tom", 23);
        User user2 = new User("Jerry", 12);
        User user3 = new User("Jack", 53);
        User user4 = new User("Jim", 34);
        User user5 = new User("Rose", 18);


        treeMap.put(user1, 78);
        treeMap.put(user2, 67);
        treeMap.put(user3, 34);
        treeMap.put(user4, 89);
        treeMap.put(user5, 79);


        Set entrySet = treeMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + " --> " +entry.getValue());
        }

    }

}
