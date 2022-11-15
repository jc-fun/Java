package com.jcfun.java;

/**
 * @ClassName: ThreadMethodsTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/8 10:01
 * @Version: 1.0.0
 * @Description: 测试Thread类的常用方法
 */
public class ThreadMethodsTest {

    public static void main(String[] args) {
        var thread1 = new Thread1("线程1");
        // thread1.setName("线程1");
        thread1.start();
    }

}


class Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }

    public Thread1() {
    }

    public Thread1(String name) {
        super(name);
    }
}