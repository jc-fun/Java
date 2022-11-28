package com.jcfun.java;

import org.testng.annotations.Test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @ClassName: UDPTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/25 下午4:29
 * @Version: 1.0.0
 * @Description: TODO
 */
public class UDPTest {

    @Test
    public void sender() throws Exception {
        DatagramSocket datagramSocket = new DatagramSocket();

        String str = "I am a data";

        DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), 0, str.length(),
            InetAddress.getByName("localhost"), 8888);

        datagramSocket.send(datagramPacket);

        datagramSocket.close();

    }


    @Test
    public void receiver() throws Exception {

        DatagramSocket datagramSocket = new DatagramSocket(8888);

        byte[] buffer = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(buffer, 0, buffer.length);

        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
        datagramSocket.close();
    }


}
