package com.jcfun.java;

import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.file.Path;

/**
 * @ClassName: RandomAccessFileTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/22 下午4:25
 * @Version: 1.0.0
 * @Description: TODO
 */
public class RandomAccessFileTest {

    @Test
    public void test1() throws Exception {
        RandomAccessFile raf1 = new RandomAccessFile("miku.jpg", "r");
        RandomAccessFile raf2 = new RandomAccessFile("miku3.jpg", "rw");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = raf1.read(buffer)) != -1) {
            raf2.write(buffer, 0, len);
        }
        raf1.close();
        raf2.close();

    }

    @Test
    public void test2() throws Exception {

        RandomAccessFile raf = new RandomAccessFile("hello2.txt", "rw");
        raf.seek(3);
        raf.write("123".getBytes());
        raf.close();

    }

    // 追加
    @Test
    public void test3() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("hello2.txt", "rw");
        raf.seek(new File("hello2.txt").length());
        raf.write("tail".getBytes());
        raf.close();
    }

    // 插入
    @Test
    public void test4() throws Exception {
        RandomAccessFile raf = new RandomAccessFile("hello2.txt", "rw");
        raf.seek(5);
        StringBuilder sb = new StringBuilder((int) new File("hello2.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while((len = raf.read(buffer)) != -1) {
            sb.append(new String(buffer), 0, len);
        }
        raf.seek(5);
        raf.write("insert".getBytes());
        raf.write(sb.toString().getBytes());
        raf.close();
    }


}
