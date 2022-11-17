package com.jcfun.java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ClassName: CallableTest
 * @Package: com.jcfun.java
 * @Author: urain
 * @Date: 2022/11/17 上午9:36
 * @Version: 1.0.0
 * @Description: TODO
 */
public class CallableTest {

    public static void main(String[] args) {

        NumThread numThread = new NumThread();
        FutureTask<Integer> futureTask = new FutureTask<>(numThread);
        new Thread(futureTask).start();
        try {
            Integer sum = futureTask.get();
            System.out.println("sum = " + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


    }


}


class NumThread implements Callable<Integer> {

    @Override
    public Integer call() {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {

            if(i % 2 == 0) {
                System.out.println("i = " + i);
                sum += i;
            }

        }
        return sum;
    }
}