package com.urain.maven;

import org.junit.Test;

/**
 * @author: urain
 * @date: 2022/4/21 22:34
 * @description:
 * @version: 1.0
 */
public class HelloTest {
    @Test
    public void testHello() {
        Hello hello = new Hello();
        hello.showMessage();
    }
}
