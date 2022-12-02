package com.com.jcfun.java;

import org.junit.Test;

import java.util.Comparator;

/**
 * @ClassName: Lambda
 * @Package: com.com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/12/2 上午9:56
 * @Version: 1.0.0
 * @Description: lambda
 */
public class LambdaTest {

    @Test
    public void test1() {

        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world!");
            }
        };
        r1.run();

        System.out.println();

        Runnable r2 = () -> System.out.println("hello world!");
        r2.run();

    }


    @Test
    public void test2() {
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };
        int compare1 = com1.compare(12, 21);
        System.out.println(compare1);

        System.out.println();

        // lambda表达式
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1, o2);
        int compare2 = com2.compare(31, 23);
        System.out.println(compare2);

        System.out.println();

        // 方法引用
        Comparator<Integer> com3 = Integer :: compare;
        int compare3 = com3.compare(45, 23);
        System.out.println(compare3);

    }


}
