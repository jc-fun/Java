package com.jcfun.java;

import org.junit.Test;

/**
 * @ClassName: ThreadTest1
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/8 16:40
 * @Version: 1.0.0
 * @Description: 通过实现Runnable接口的方式创建多线程
 */
public class ThreadTest1 {

    @Test
    public void test() {

        Mthread mthread = new Mthread();
        Thread thread = new Thread(mthread);
        thread.start();

    }

}


class Mthread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}