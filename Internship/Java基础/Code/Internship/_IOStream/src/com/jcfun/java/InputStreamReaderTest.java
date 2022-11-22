package com.jcfun.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * @ClassName: InputStreamReader
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/22 上午10:34
 * @Version: 1.0.0
 * @Description: TODO
 */
public class InputStreamReaderTest {


    @Test
    public void test1() throws Exception{

        FileInputStream fis = new FileInputStream("hello.txt");

        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);

        char[] buffer = new char[20];
        int len;
        while((len = isr.read(buffer)) != -1) {
            String str = new String(buffer, 0 , len);
            System.out.println(str);
        }
        isr.close();

    }


}
