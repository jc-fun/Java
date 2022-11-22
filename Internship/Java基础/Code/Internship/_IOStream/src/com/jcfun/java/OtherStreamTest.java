package com.jcfun.java;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName: OtherStreamTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/22 上午11:22
 * @Version: 1.0.0
 * @Description: TODO
 */
public class OtherStreamTest {

    /**
     * System.in
     * System.out
     */
    @Test
    public void test1() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true) {
            System.out.print("请输入字符串：");
            String data = br.readLine();
            if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                System.out.println("程序结束");
                break;
            }
            String upperCase = data.toUpperCase();
            System.out.println(upperCase);

        }
        br.close();
    }


    /**
     * PrintStream
     * PrintWriter
     */
    @Test
    public void test2() {
        PrintStream ps = null;
        try {
            FileOutputStream fos = new FileOutputStream("character.txt");
            // 创建打印输出流,设置为自动刷新模式(写入换行符或字节 '\n' 时都会刷新输出缓冲区)
            ps = new PrintStream(fos, true);
            if (ps != null) {// 把标准输出流(控制台输出)改成文件
                System.setOut(ps);
            }
            for (int i = 0; i <= 255; i++) { // 输出ASCII字符
                System.out.print((char) i);
                if (i % 50 == 0) { // 每50个数据一行
                    System.out.println(); // 换行
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }

    }


    /**
     * DataInputStream
     * DataOutputStream
     */
    @Test
    public void test3() throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));

        dos.writeUTF("可达鸭");
        dos.flush();
        dos.writeInt(32);
        dos.flush();
        dos.writeBoolean(true);
        dos.flush();

        dos.close();
    }
    @Test
    public void test4() throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));

        String str = dis.readUTF();
        int age = dis.readInt();
        boolean isMale = dis.readBoolean();
        System.out.println("str = " + str);
        System.out.println("age = " + age);
        System.out.println("isMale = " + isMale);

        dis.close();
    }

}
