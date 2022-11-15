package com.urain.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @author: urain
 * @date: 2022/4/24 10:52
 * @description:
 * @version: 1.0
 */
public class JDKProxy {
    public static void main(String[] args) {
        // 创建接口实现类的代理对象
        Class [] interfaces = {UserDAO.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });

        UserDAOImpl userDAO = new UserDAOImpl();
        UserDAO dao = (UserDAO) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDAOProxy(userDAO));
        int result = dao.add(1, 2);
        System.out.println("result:" + result);
    }
}

// 创建代理对象代码
class UserDAOProxy implements InvocationHandler {

    // 1.创建的是谁的代理对象，就把谁传递过来
    // 有参构造传递
    private Object obj;
    public UserDAOProxy(Object obj) {
        this.obj = obj;
    }


    // 增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 方法之前
        System.out.println("方法之前执行......" + method.getName() + ":传递的参数..." + Arrays.toString(args));
//        System.out.println(proxy);

        // 被增强的方法执行
        Object res = method.invoke(obj, args);

        // 方法之后
        System.out.println("方法之后执行......" + obj);

        return res;
    }
}
