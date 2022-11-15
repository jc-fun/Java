package com.jcfun.java;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: CollectionTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/3 17:08
 * @Version: 1.0.0
 * @Description: Collection接口中声明的方法的测试
 */
public class CollectionTest {

    @Test
    public void test1() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jerry", 18));


        // contains()：判断当前集合中是否包含obj
        boolean contains = coll.contains(123);
        System.out.println("contains = " + contains);
        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Jerry", 18)));
        
        // containsAll(coll1)：判断形参coll1中的所有元素是否都存在于集合coll中
        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void test2() {
        // remove
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jerry", 18));
        coll.remove(123);
        System.out.println("coll = " + coll);


        // removeAll(coll1)：从当前集合中移除出coll1中所有元素
        Collection coll1 = Arrays.asList(123, 456);
        coll.removeAll(coll1);
        System.out.println("coll = " + coll);

    }

    @Test
    public void test3() {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add("Tom");
        coll.add(false);
        coll.add(new Person("Jerry", 18));
        // Collection coll1 = Arrays.asList(123, 456, 789);
        // // retainAll()
        // coll.retainAll(coll1);
        // System.out.println(coll);



        // equals()
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add("Tom");
        coll1.add(false);
        coll1.add(new Person("Jerry", 18));
        System.out.println(coll.equals(coll1));


        // hashCode()：
        System.out.println(coll.hashCode());


        // toArray() 集合 --> 数组
        Object[] arr = coll.toArray();
        for (Object o : arr) {
            System.out.println(o);
        }
        // 基本数据类型的数组会被视为一个元素
        int[] arr1 = new int[]{123, 456};
        System.out.println(Arrays.asList(arr1));
        System.out.println(Arrays.asList(123, 456));


        // iterator()：返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest中测试



    }


}
