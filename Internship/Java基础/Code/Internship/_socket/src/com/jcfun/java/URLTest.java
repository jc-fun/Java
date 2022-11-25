package com.jcfun.java;

import org.testng.annotations.Test;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * @ClassName: URLTest
 * @Package: com.jcfun.java
 * @Author: jcfun
 * @Date: 2022/11/25 19:10
 * @Version: 1.0.0
 * @Description: TODO
 */
public class URLTest {

    @Test
    public void test() throws Exception {

        URL url = new URL("https://img0.baidu.com/it/u=561734853," +
            "2461096286&fm=253&app=138&size=w931&n=0&f=JPEG&fmt=auto?sec=1669482000&t=3e1d482155bacefcb1e818b5e5a2d4b8");
        HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
        urlConnection.connect();

        InputStream is = urlConnection.getInputStream();
        FileOutputStream fos = new FileOutputStream("1.jpg");

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            fos.write(buffer, 0, len);
        }

        fos.close();
        is.close();
        urlConnection.disconnect();



    }


}
