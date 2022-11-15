package com.urain._wrapper;

/**
 * @ClassName: wrapperTest1
 * @Package: com.urain._wrapper
 * @Author: urain
 * @Date: 2022/8/27 20:16
 * @Version: 1.0.0
 * @Description: TODO
 */
public class WrapperTest1 {


    public static void main(String[] args) {

        // JDK 1.5 之后实现了自动装箱和拆箱
        // 手动装箱和拆箱
        Integer i = new Integer(1);
        Integer j = Integer.valueOf(1);

        int k = i.intValue();


        // Integer -> String
        // 方式1
        Integer i1 = 100;
        String str1 = i1 + "";
        // 方式2
        String s1 = i1.toString();
        // 方式3
        String s2 = String.valueOf(i1);

        // String -> Integer
        int i2 = Integer.parseInt(s1);
        Integer i3 = new Integer(s1);
        Integer i4 = Integer.valueOf(s2);




    }


}
