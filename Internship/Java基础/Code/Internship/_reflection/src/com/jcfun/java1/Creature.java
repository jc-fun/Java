package com.jcfun.java1;

import java.io.Serializable;

/**
 * @ClassName: Creature
 * @Package: com.jcfun.java1
 * @Author: jcfun
 * @Date: 2022/11/29 上午10:17
 * @Version: 1.0.0
 * @Description: TODO
 */
public class Creature<T> implements Serializable {

    private char gender;
    public double weight;

    private void breath() {
        System.out.println("生物呼吸");
    }

    public void eat() {
        System.out.println("生物吃东西");
    }

}
