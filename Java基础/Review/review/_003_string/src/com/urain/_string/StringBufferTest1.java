package com.urain._string;

/**
 * @ClassName: StringBufferTest1
 * @Package: com.urain._string
 * @Author: urain
 * @Date: 2022/8/28 20:54
 * @Version: 1.0.0
 * @Description: TODO
 */
public class StringBufferTest1 {


    public static void main(String[] args) {

        // 初始化长度为16的char[]
        var sb1 = new StringBuffer();

        // 指定初始化长度
        var sb2 = new StringBuffer(20);

        // 初始化长度为 (str.length + 16)
        StringBuffer sb3 = new StringBuffer("stringBuffer");

    }




}
