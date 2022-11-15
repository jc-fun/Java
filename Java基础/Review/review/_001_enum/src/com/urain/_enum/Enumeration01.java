package com.urain._enum;

/**
 * @ClassName: Enumeration01
 * @Package: com.urain._enum
 * @Author: urain
 * @Date: 2022/8/25 22:23
 * @Version: 1.0.0
 * @Description: TODO
 */
public class Enumeration01 {


    public static void main(String[] args) {
        System.out.println(Season.SPRING.getName() + " -> " + Season.SPRING.getDesc());
        System.out.println(Season.WINTER);
        System.out.println(Season.AUTUMN);
        System.out.println(Season.SUMMER);
    }





}

/**
 * 自定义枚举类
 */
class Season {

    private final String name;
    private final String desc;

    public final static Season SPRING = new Season("春天", "温暖");
    public final static Season WINTER = new Season("冬天", "寒冷");
    public final static Season AUTUMN = new Season("秋天", "凉爽");
    public final static Season SUMMER = new Season("夏天", "炎热");


    // 1.将构造器私有化，防止直接创建对象
    // 2.去掉setter方法，反之直接修改属性
    // 3.在类内部直接创建固定的对象
    // 4.可以对创建的对象使用final修饰

    private Season(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }


    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Season{" +
            "name='" + name + '\'' +
            ", desc='" + desc + '\'' +
            '}';
    }
}
