package com.jcfun.java;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: LockTest
 * @Package: com.jcfun.java
 * @Author: urain
 * @Date: 2022/11/16 上午10:24
 * @Version: 1.0.0
 * @Description: TODO
 */
public class LockTest {

    public static void main(String[] args) {
        Window window = new Window();

        Thread thread1 = new Thread(window);
        Thread thread2 = new Thread(window);
        Thread thread3 = new Thread(window);

        thread1.start();
        thread2.start();
        thread3.start();

    }

}


class Window implements Runnable {

    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ": ticket = " + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}