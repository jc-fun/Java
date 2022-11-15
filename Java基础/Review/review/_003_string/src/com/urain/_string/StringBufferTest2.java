package com.urain._string;

/**
 * @ClassName: StringBufferTest2
 * @Package: com.urain._string
 * @Author: urain
 * @Date: 2022/8/28 21:26
 * @Version: 1.0.0
 * @Description: TODO
 */
public class StringBufferTest2 {

    public static void main(String[] args) {

        // String -> StringBuffer
        String str = "hello world";

        // 使用StringBuffer构造器返回一个StringBuffer
        var sb1 = new StringBuffer(str);

        // 使用append()方法
        var sb2 = new StringBuffer();
        sb2 = sb2.append(str);


        // StringBuffer -> String
        // 使用toString() 方法
        StringBuffer sb3 = new StringBuffer("hello world");
        String str2 = sb3.toString();

        // 使用构造器
        String st3 = new String(sb3);


    }



}
