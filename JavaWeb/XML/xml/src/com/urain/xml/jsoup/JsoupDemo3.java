package com.urain.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author: urain
 * @date: 2022/4/22 12:58
 * @description: Document 对象功能
 * @version: 1.0
 */
public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        // 获取Document文档对象
        // 获取student.xml的path
        String path = JsoupDemo3.class.getClassLoader().getResource("student.xml").getPath();
        // 获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 获取元素对象
        // 1.获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);

        System.out.println("-------------------------");

        // 获取属性名为id的元素对象
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);

        System.out.println("-------------------------");

        // 获取number属性值为heima_0001的元素对象
        Elements elements2 = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(elements2);

        System.out.println("-------------------------");

        // 获取id属性值为itcast的元素对象
        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);


    }
}
