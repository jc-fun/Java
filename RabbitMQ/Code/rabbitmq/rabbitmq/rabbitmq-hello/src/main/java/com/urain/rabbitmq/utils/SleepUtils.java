package com.urain.rabbitmq.utils;

/**
 * @ClassName: SleepUtils
 * @Package: com.urain.rabbitmq.utils
 * @Author: urain
 * @Date: 2022/9/21 23:18
 * @Version: 1.0.0
 * @Description: TODO
 */
public class SleepUtils {

    public static void sleep(int seconds) {
        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
