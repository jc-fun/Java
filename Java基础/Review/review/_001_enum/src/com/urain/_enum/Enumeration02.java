package com.urain._enum;

/**
 * @ClassName: Enumeration01
 * @Package: com.urain._enum
 * @Author: urain
 * @Date: 2022/8/25 22:23
 * @Version: 1.0.0
 * @Description: TODO
 */
public class Enumeration02 {


    public static void main(String[] args) {
        System.out.println(Season2.SPRING.getName() + " -> " + Season2.SPRING.getDesc());
        System.out.println(Season2.WINTER);
        System.out.println(Season2.AUTUMN);
        System.out.println(Season2.SUMMER);
    }





}

/**
 * 使用enum关键字实现枚举类
 */
enum Season2{

    // 1.使用enum关键字替代class
    // 2.使用 常量名(实参列表) 的形式创建常量对象
    // 3.如果有多个常量(对象)，使用 , 间隔即可
    // 4.如果使用enum实现枚举，要求将定义常量对象放在最前面
    // 5.如果使用无参构造器来创建常量对象，可以省略()

    SPRING("春天", "温暖"),
    SUMMER("夏天", "炎热"),
    AUTUMN("秋天", "凉爽"),
    WINTER("冬天", "寒冷");

    private final String name;
    private final String desc;

    Season2(String name, String desc) {
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
