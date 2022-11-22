package com.jcfun.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @ClassName: ObjectInputOutputStreamTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/22 下午3:51
 * @Version: 1.0.0
 * @Description: TODO
 */
public class ObjectInputOutputStreamTest {

    /**
     * 序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去，使用ObjectOutputStream
     */
    @Test
    public void test1() throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
        oos.writeObject("我爱北京天安门");
        oos.flush();
        oos.close();
    }
    /**
     * 反序列化：将磁盘中的对象还原为内存中的一个java对象，使用ObjectInputStream
     */
    @Test
    public void test2() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.dat"));
        Object obj = ois.readObject();
        String str = (String) obj;
        System.out.println(str);
        ois.close();
    }
}
