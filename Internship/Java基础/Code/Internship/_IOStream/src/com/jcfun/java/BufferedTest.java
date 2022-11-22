package com.jcfun.java;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName: BufferedTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/22 上午9:12
 * @Version: 1.0.0
 * @Description: TODO
 */
public class BufferedTest {


    @Test
    public void bufferedStreamTest() {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File srcFile = new File("miku.jpg");
            File destFile = new File("miku2.jpg");

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert bos != null;
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 关闭外层流的同时，内层流也会自动关闭。
        // fos.close();
        // fis.close();
    }


}
