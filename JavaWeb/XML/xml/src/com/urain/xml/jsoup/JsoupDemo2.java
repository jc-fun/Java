package com.urain.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

/**
 * @author: urain
 * @date: 2022/4/22 12:58
 * @description: Jsoup 对象
 * @version: 1.0
 */
public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        // 获取Document文档对象

        // 获取student.xml的path
        //String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        // 方式一：解析xml文档，加载文档进内存，获取dom树 ---> Document
        //Document document = Jsoup.parse(new File(path), "utf-8");
        //System.out.println(document);


        // 方式二：parse(String html)：解析xml或html字符串
        /*String str = "<!--?xml version=\"1.0\" encoding=\"UTF-8\" ?-->\n" +
            "<html>\n" +
            " <head></head>\n" +
            " <body>\n" +
            "  <students> \n" +
            "   <student number=\"heima_0001\"> \n" +
            "    <name>\n" +
            "     tom\n" +
            "    </name> \n" +
            "    <age>\n" +
            "     18\n" +
            "    </age> \n" +
            "    <sex>\n" +
            "     male\n" +
            "    </sex> \n" +
            "   </student> \n" +
            "   <student number=\"heima_0002\"> \n" +
            "    <name>\n" +
            "     jack\n" +
            "    </name> \n" +
            "    <age>\n" +
            "     20\n" +
            "    </age> \n" +
            "    <sex>\n" +
            "     female\n" +
            "    </sex> \n" +
            "   </student> \n" +
            "  </students>\n" +
            " </body>\n" +
            "</html>";
        Document document = Jsoup.parse(str);
        System.out.println(document);*/


        // 方式三：parse(URL url, int timeoutMillis)：通过网络路径获取指定的html或xml文档对象
        URL url = new URL("https://baike.baidu.com/item/jsoup/9012509?fr=aladdin");
        Document document = Jsoup.parse(url, 100000);
        System.out.println(document);


    }
}
