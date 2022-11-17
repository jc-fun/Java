package com.jcfun.java;

/**
 * @ClassName: Deadlock
 * @Package: com.jcfun.java
 * @Author: urain
 * @Date: 2022/11/16 上午9:35
 * @Version: 1.0.0
 * @Description: TODO
 */
public class Deadlock {


    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {
                    s1.append("a");
                    s2.append("1");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");

                        System.out.println("s1 = " + s1);
                        System.out.println("s2 = " + s2);
                    }

                }
            }
        }.start();

        new Thread(() -> {
            synchronized (s2) {
                s1.append("c");
                s2.append("3");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (s1) {
                    s1.append("d");
                    s2.append("4");

                    System.out.println("s1 = " + s1);
                    System.out.println("s2 = " + s2);
                }

            }
        }).start();

    }


}
