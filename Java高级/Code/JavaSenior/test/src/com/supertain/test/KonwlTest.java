package com.supertain.test;

import org.testng.annotations.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: supertain
 * @Date: 2022/2/21 18:55
 * @Description:
 */
public class KonwlTest {
    @Test
    public void client() {
        OutputStream sg = null;
        Socket socket = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet, 9999);
            sg = socket.getOutputStream();
            FileInputStream fileInputStream = new FileInputStream(new File("angle.png"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                sg.write(buffer, 0, len);
            }
            sg.write("Hello World!".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sg != null) {
                try {
                    sg.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream inputStream = null;
        ByteArrayOutputStream baos = null;
        FileOutputStream fos = null;
        try {
            ss = new ServerSocket(9999);
            socket = ss.accept();
            inputStream = socket.getInputStream();
            fos = new FileOutputStream(new File("angle1.png"));
            byte[] imgBuffer = new byte[1024];
            int imgLen;
            while ((imgLen = inputStream.read(imgBuffer)) != -1) {
                fos.write(imgBuffer, 0, imgLen);
            }
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[5];
            int len;
            while ((len = inputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            System.out.println(baos.toString());
            System.out.println("收到了来自" + socket.getInetAddress().getHostAddress() + "的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos != null) {

                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {

                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {

                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {

                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
