package com.urain.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author: urain
 * @date: 2022/4/24 14:41
 * @description:
 * @version: 1.0
 */

// 被增强的类
@Component
public class User {
    public void add() {
//        int i = 10 / 0;
        System.out.println("add......");
    }
}
