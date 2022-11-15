package com.jcfun.java;

import org.junit.Test;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @ClassName: SerialTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/8 8:47
 * @Version: 1.0.0
 * @Description: TODO
 */
public class SerialTest {

    volatile static Thread thread1, thread2, thread3, thread4;

    @Test
    public void test2() throws InterruptedException {

        createThread();

        thread1.setName("线程1");
        thread2.setName("线程2");
        thread3.setName("线程3");
        thread4.setName("线程4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        Thread.sleep(20000);
    }

    private static void createThread() {
        long startTime = System.currentTimeMillis();
        thread1 = new Thread(() -> {
            synchronized (SerialTest.class) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long endTime = System.currentTimeMillis();
                System.out.println(currentThread().getName() + "执行结束，当前所花费的时间为: " + (endTime - startTime));
            }
        });
        thread2 = new Thread(() -> {
            synchronized (SerialTest.class) {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long endTime = System.currentTimeMillis();
                System.out.println(currentThread().getName() + "执行结束，当前所花费的时间为: " + (endTime - startTime));
            }
        });
        thread3 = new Thread(() -> {
            synchronized (SerialTest.class) {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long endTime = System.currentTimeMillis();
                System.out.println(currentThread().getName() + "执行结束，当前所花费的时间为: " + (endTime - startTime));
            }
        });
        thread4 = new Thread(() -> {
            synchronized (SerialTest.class) {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long endTime = System.currentTimeMillis();
                System.out.println(currentThread().getName() + "执行结束，当前所花费的时间为: " + (endTime - startTime));
            }
        });

    }
}