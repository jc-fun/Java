package com.jcfun.java;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName: FileReaderWriterTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/21 上午9:14
 * @Version: 1.0.0
 * @Description: TODO
 */
public class FileReaderWriterTest {

    @Test
    public void testFileReader() {
        FileReader fr = null;
        try {
            File file = new File("hello.txt");

            // 提供具体的流
            fr = new FileReader(file);

            // 数据的读入
            // 方式一：
            // int data = fr.read();
            // while (data != -1) {
            //     System.out.println((char) data);
            //     data = fr.read();
            // }

            // 方式二：
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                assert fr != null;
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


    @Test
    public void testFileReader1() throws Exception {

        File file = new File("hello.txt");
        FileReader fileReader = new FileReader(file);
        char[] cbuf = new char[5];
        int len;
        while ((len = fileReader.read(cbuf)) != -1) {
            // 方式一：
            // for (int i = 0; i < len; i++) {
            //     System.out.print(cbuf[i]);
            // }

            // 方式二：
            String str = new String(cbuf, 0, len);
            System.out.print(str);
        }

    }


    @Test
    public void testFileWriter() throws Exception {
        File file = new File("hello1.txt");

        FileWriter fw = new FileWriter(file, false);

        fw.write("I have a dream!\n");
        fw.write("you need to have a dream!");

        fw.close();

    }


    @Test
    public void testFileReaderFileWriter() throws Exception {

        File srcFile = new File("hello.txt");
        File destFile = new File("hello2.txt");

        FileReader fr = new FileReader(srcFile);
        FileWriter fw = new FileWriter(destFile);

        char[] cbuf = new char[5];
        int len;
        while ((len = fr.read(cbuf)) != -1) {
            fw.write(cbuf, 0, len);
        }

        fw.close();
        fr.close();
    }


    @Test
    public void testFileInputOutputStream() throws Exception {

        File srcFile = new File("miku.jpg");
        File destFile = new File("miku1.jpg");

        FileInputStream fileInputStream = new FileInputStream(srcFile);
        FileOutputStream fileOutputStream = new FileOutputStream(destFile);

        byte[] buffer = new byte[5];
        int len;
        while((len = fileInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, len);
        }

        fileOutputStream.close();
        fileInputStream.close();

    }




}
