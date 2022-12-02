package com.jcfun.java3;

import org.junit.Test;

/**
 * @ClassName: StaticProxyTest
 * @Package: com.jcfun.java3
 * @Author: jcfun
 * @Date: 2022/11/30 上午10:42
 * @Version: 1.0.0
 * @Description: 静态代理
 */
public class StaticProxyTest {
    @Test
    public void test() {
        // 创建被代理类的对象
        ClothFactory nike = new NikeClothFactory();
        // 创建代理类的对象
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);

        proxyClothFactory.produceCloth();

    }

}


interface ClothFactory {
    void produceCloth();
}

// 代理类
class ProxyClothFactory implements ClothFactory {

    private final ClothFactory factory;

    public ProxyClothFactory(ClothFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceCloth() {

        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");

    }
}

// 被代理类
class NikeClothFactory implements ClothFactory {

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}