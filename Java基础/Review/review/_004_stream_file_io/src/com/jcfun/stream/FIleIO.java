package com.jcfun.stream;

import java.io.IOException;

/**
 * @ClassName: FIleIO
 * @Package: com.jcfun.stream
 * @Author: jcfun
 * @Date: 2022/11/3 14:35
 * @Version: 1.0.0
 * @Description: TODO
 */
public class FIleIO {


    public static void main(String[] args) throws IOException {
        // // 读写文件
        // var f = new File("./hello.txt");
        // var os = new FileOutputStream(f);
        //
        //
        // var is  = new FileInputStream(f);
        // byte bWrite[] = {11, 21, 3, 40, 5};
        // for (int i = 0; i < bWrite.length; i++) {
        //     os.write(bWrite[i]);
        // }
        // os.close();
        //
        // int size = is.available(); // 每次使用read()后is.available的值都会变
        // for (int j = 0; j < size; j++) {
        //     System.out.println((char) is.read() + " ");
        // }
        // is.close();



        // // 解决乱码问题
        // var f = new File("./hello1.txt");
        // var fop = new FileOutputStream(f);
        // var writer = new OutputStreamWriter(fop, StandardCharsets.UTF_8);
        // writer.append("中文输入\r\n");
        // writer.append("English");
        // writer.close();
        // fop.close();
        // var fip = new FileInputStream(f);
        // var reader = new InputStreamReader(fip, StandardCharsets.UTF_8);
        // var sb = new StringBuilder();
        // while(reader.ready()) {
        //     sb.append((char) reader.read());
        // }
        // System.out.println(sb);
        // reader.close();
        // fip.close();

    }
}
