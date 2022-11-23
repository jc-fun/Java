package com.jcfun.java;

import org.testng.annotations.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ClassName: InetAddressTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/23 下午4:08
 * @Version: 1.0.0
 * @Description: TODO
 */
public class InetAddressTest {


    @Test
    public void test1() throws UnknownHostException {

        InetAddress inet = InetAddress.getByName("localhost");
        System.out.println("inet = " + inet);

        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println("localHost = " + localHost);




    }


}
