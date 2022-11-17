package com.jcfun.java;

/**
 * @ClassName: CommunicationTest
 * @Package: com.jcfun.java
 * @Author: urain
 * @Date: 2022/11/17 上午8:50
 * @Version: 1.0.0
 * @Description: TODO
 */
public class CommunicationTest {

    public static void main(String[] args) {

        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }




}


class Number implements Runnable {

    private int number = 1;

    @Override
    public void run() {
        while (true) {

            synchronized (this) {

                notify();

                if(number <= 100) {

                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;

                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    break;
                }
            }

        }
    }
}