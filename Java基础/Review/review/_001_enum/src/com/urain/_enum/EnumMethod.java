package com.urain._enum;

/**
 * @ClassName: EnumMethod
 * @Package: com.urain._enum
 * @Author: urain
 * @Date: 2022/8/26 21:13
 * @Version: 1.0.0
 * @Description: TODO
 */
public class EnumMethod {


    public static void main(String[] args) {

        // 使用Season2演示ENUM的方法
        Season2 spring = Season2.SPRING;

        // 输出枚举对象的名字
        System.out.println(spring.name());

        // ordinal() 输出的是该枚举对象的次序/编号，从0开始
        System.out.println(spring.ordinal());

        // values() 含有所有定义的枚举对象
        for(Season2 season : Season2.values()) {
            System.out.println("season = " + season);
        }

        // valueOf() 将字符串转换成枚举对象，要求字符串必须为已有的常量名
        Season2 autumn = Season2.valueOf("AUTUMN");
        System.out.println("autumn = " + autumn);

        // compareTo 根据编号比较两个枚举常量，结果为自身的编号和比较对象的编号的差
        System.out.println(Season2.SPRING.compareTo(autumn));


    }



}
