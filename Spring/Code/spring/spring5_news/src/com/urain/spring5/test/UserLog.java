package com.urain.spring5.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: urain
 * @date: 2022/4/25 15:32
 * @description:
 * @version: 1.0
 */

public class UserLog {
    private static final Logger log = LoggerFactory.getLogger(UserLog.class);

    public static void main(String[] args) {
        log.info("hello log4j2");
        log.warn("hello log4j2");
    }
}
