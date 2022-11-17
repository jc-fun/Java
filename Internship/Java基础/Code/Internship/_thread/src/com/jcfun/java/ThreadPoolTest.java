package com.jcfun.java;

import java.util.concurrent.*;

/**
 * @ClassName: ThreadPoolTest
 * @Package: com.jcfun.java
 * @Author: urain
 * @Date: 2022/11/17 上午10:49
 * @Version: 1.0.0
 * @Description: TODO
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executor = (ThreadPoolExecutor) executorService;
        // executor.setCorePoolSize(15);
        // executor.setMaximumPoolSize(20);
        executorService.execute(new NumberThread()); // 适合使用Runnable
        Future<Integer> futureTask = executorService.submit(new NumberThread1());// 适合使用Callable
        System.out.println("sum = " + futureTask.get());

        executorService.shutdown();
    }

}


class NumberThread implements Runnable {


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class NumberThread1 implements Callable<Integer> {


    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
                sum += i;
            }
        }
        return sum;
    }
}