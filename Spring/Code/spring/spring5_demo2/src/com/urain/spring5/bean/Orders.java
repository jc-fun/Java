package com.urain.spring5.bean;

/**
 * @author: urain
 * @date: 2022/4/23 17:46
 * @description:
 * @version: 1.0
 */
public class Orders {
    private String oname;

    public Orders() {
        System.out.println("第一步，执行无参数构造器创建bean实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步，调用set方法设置属性值");
    }

    // 创建执行的初始化的方法
    public void initMethod() {
        System.out.println("第三步，执行初始化的方法");
    }

    // 创建执行的销毁的方法
    public void destroyMethod() {
        System.out.println("第五步，执行的销毁的方法");
    }
}
