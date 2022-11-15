package com.jcfun.java;

import org.junit.Test;

/**
 * @ClassName: ThreadTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/8 9:43
 * @Version: 1.0.0
 * @Description: 多线程的创建：继承Thread类
 */
public class ThreadTest {

    @Test
    public void test1() {
        var threadA = new ThreadA();
        threadA.start();
    }

}


class ThreadA extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}