package com.jcfun.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

/**
 * @ClassName: ParallelTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/8 8:47
 * @Version: 1.0.0
 * @Description: TODO
 */
public class ParallelTest {

    @Test
    public void test1() throws InterruptedException {


        Callable<Object> callable1 = () -> {
            sleep(1000);
            System.out.println(currentThread().getName() + "执行完毕");
            return null;
        };
        Callable<Object> callable2 = () -> {
            sleep(2000);
            System.out.println(currentThread().getName() + "执行完毕");
            return null;
        };
        Callable<Object> callable3 = () -> {
            sleep(3000);
            System.out.println(currentThread().getName() + "执行完毕");
            return null;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        var tasks = new ArrayList<Callable<Object>>();
        tasks.add(callable1);
        tasks.add(callable2);
        tasks.add(callable3);
        executorService.invokeAll(tasks);

        executorService.shutdownNow();

        Thread.sleep(10000);

    }


}





class ThreadA extends Thread {


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        long endTime = System.currentTimeMillis();
        System.out.println(getName() + "执行结束，当前所花费的时间为: " + (endTime - startTime));
    }


}


class ThreadB extends Thread {

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        long endTime = System.currentTimeMillis();
        System.out.println(getName() + "执行结束，当前所花费的时间为: " + (endTime - startTime));
    }
}


class ThreadC extends Thread {


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        long endTime = System.currentTimeMillis();
        System.out.println(getName() + "执行结束，当前所花费的时间为: " + (endTime - startTime));
    }

}


class ThreadD extends Thread {


    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        long endTime = System.currentTimeMillis();
        System.out.println(getName() + "执行结束，当前所花费的时间为: " + (endTime - startTime));
    }

}