package com.jcfun.java;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: TCPTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/25 下午4:02
 * @Version: 1.0.0
 * @Description: TODO
 */
public class TCPTest2 {


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
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream("miku1.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        fos.close();
        is.close();
        socket.close();

    }


}
