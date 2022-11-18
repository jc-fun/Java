package com.jcfun.java;

import org.junit.Test;

import java.io.File;

/**
 * @ClassName: FileTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/18 下午4:28
 * @Version: 1.0.0
 * @Description: TODO
 */
public class FileTest {

    @Test
    public void test1() {

        File file = new File("hello.txt");
        File folder = new File("./", "folder");
        File file1 = new File(folder, "1.txt");


        System.out.println("file = " + file);
        System.out.println("folder = " + folder);
        System.out.println("file1 = " + file1);


    }




}
