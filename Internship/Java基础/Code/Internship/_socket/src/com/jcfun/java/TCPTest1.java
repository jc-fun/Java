package com.jcfun.java;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: TCPTest1
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/24 下午4:02
 * @Version: 1.0.0
 * @Description: TODO
 */
public class TCPTest1 {

    @Test
    public void client() throws Exception {
        InetAddress inetAddress = InetAddress.getByName("localhost");
        Socket socket = new Socket(inetAddress, 8888);
        // Socket socket = new Socket("localhost", 80);
        OutputStream os = socket.getOutputStream();
        os.write("I am client".getBytes());

        os.close();
        socket.close();
    }

    @Test
    public void server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();

        // 乱码
        // byte[] buffer = new byte[20];
        // int len;
        // while ((len = is.read(buffer)) != -1) {
        //     String str = new String(buffer, 0, len);
        //     System.out.print("str = " + str);
        // }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer = new byte[5];
        int len;
        while ((len = is.read(buffer)) != -1) {
            baos.write(buffer, 0, len);
        }

        System.out.println(baos);

        baos.close();
        is.close();
        socket.close();
        serverSocket.close();


    }


}
