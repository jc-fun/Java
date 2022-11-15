package com.jcfun.java;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @ClassName: CountDownLatchTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/8 16:09
 * @Version: 1.0.0
 * @Description: TODO
 */
public class CountDownLatchTest {

    @Test
    public void test() throws InterruptedException {

        var countdownLatch = new CountDownLatch(3);

        for (long i = 1; i <= 3; i++) {
            long finalI = i * 1000;
            new Thread(() -> {
                try {
                    Thread.sleep(finalI);
                    System.out.println(Thread.currentThread().getName() + "执行完毕");
                    countdownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        countdownLatch.await();

        System.out.println("线程全部执行完毕");

        Thread.sleep(10000);

    }



}
