package com.jcfun.java3;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: DynamicProxyTest
 * @Package: com.jcfun.java3
 * @Author: jcfun
 * @Date: 2022/11/30 上午11:28
 * @Version: 1.0.0
 * @Description: 动态代理
 */
public class DynamicProxyTest {

    @Test
    public void test() {
        SuperMan superMan = new SuperMan();
        // proxyInstance：代理类的对象
        Human proxyInstance = (Human) ProxyFactory.getProxyInstance(superMan);
        String belief = proxyInstance.getBelief();
        System.out.println(belief);
        proxyInstance.eat("四川麻辣烫");

        System.out.println();

        NikeClothFactory nikeClothFactory = new NikeClothFactory();
        ClothFactory proxyClothInstance = (ClothFactory) ProxyFactory.getProxyInstance(nikeClothFactory);
        proxyClothInstance.produceCloth();

    }

}


interface Human {

    String getBelief();

    void eat(String food);

}

// 被代理类
class SuperMan implements Human {

    @Override
    public String getBelief() {
        return "I believe I can fly!";
    }

    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃：" + food);
    }
}

// 想要实现动态代理，需要解决的问题
// 1.如何根据加载到内存中的被代理类 ，动态的创建一个代理类及其对象
// 2.当通过代理类的对象调用方法时，如果动态的去调用被代理类中的同名方法
class ProxyFactory {
    // 调用此方法，返回一个代理类的对象，解决问题1
    public static Object getProxyInstance(Object obj) { // 被代理类的对象
        MyInvocationHandler handler = new MyInvocationHandler();
        handler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
            handler);
    }
}

class MyInvocationHandler implements InvocationHandler {

    private Object obj; // 需要使用被代理类的对象进行赋值

    public void bind(Object obj) {
        this.obj = obj;
    }

    // 当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()
    // 将被代理类要执行的方法a的功能声明在invoke()中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        HumanUtil util = new HumanUtil();
        util.method1();

        // 代理类的对象
        // method：即为代理类对象调用的方法，此方法也就作为了被代理类的对象要调用的方法
        // obj：被代理类的对象
        Object returnValue = method.invoke(obj, args);

        util.method2();
        // 上述方法的返回值就作为当前类中的invoke()的返回值
        return returnValue;
    }
}


class HumanUtil {
    public void method1() {
        System.out.println("通用方法1");
    }

    public void method2() {
        System.out.println("通用方法2");
    }
}