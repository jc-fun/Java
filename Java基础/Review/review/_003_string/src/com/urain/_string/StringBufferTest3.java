package com.urain._string;

/**
 * @ClassName: StringBufferTest3
 * @Package: com.urain._string
 * @Author: urain
 * @Date: 2022/8/28 21:32
 * @Version: 1.0.0
 * @Description: TODO
 */
public class StringBufferTest3 {

    public static void main(String[] args) {

        // append()
        var sb1 = new StringBuffer();
        sb1.append("hello ");
        sb1.append(123);
        System.out.println(sb1);

        // delete()
        sb1.delete(1, 2);
        System.out.println("sb1 = " + sb1);

        // replace()
        sb1.replace(1, 2, "el");
        System.out.println("sb1 = " + sb1);


    }

}
