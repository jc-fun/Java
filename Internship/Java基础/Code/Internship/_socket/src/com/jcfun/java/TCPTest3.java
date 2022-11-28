package com.jcfun.java;

import org.testng.annotations.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: TCPTest3
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/25 下午4:14
 * @Version: 1.0.0
 * @Description: TODO
 */
public class TCPTest3 {


    @Test
    public void client() throws Exception {

        Socket socket = new Socket("localhost", 8888);
        OutputStream os = socket.getOutputStream();

        FileInputStream fis = new FileInputStream("miku.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        // 关闭数据输出
        socket.shutdownOutput();

        // 接受回复
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[20];
        int len1;
        while ((len = is.read(buffer1)) != -1) {
            baos.write(buffer1, 0, len);
        }
        System.out.println(baos);

        fis.close();
        os.close();
        socket.close();
        baos.close();
        is.close();
    }

    @Test
    public void server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("miku2.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        // 回复
        OutputStream os = socket.getOutputStream();
        os.write("已收到发送的图片".getBytes());

        fos.close();
        is.close();
        socket.close();
        os.close();

    }


}
