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
 * @description: Jsoup 快速入门
 * @version: 1.0
 */
public class JsoupDemo1 {
    public static void main(String[] args) throws IOException {
        // 获取Document文档对象

        // 获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        System.out.println(path);
        // 解析xml文档，加载文档进内存，获取dom树 ---> Document
        Document document = Jsoup.parse(new File(path), "utf-8");
        // 获取元素对象
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());

        // 获取第一个name的Element对象
        Element element = elements.get(0);
        // 获取数据
        String name = element.text();
        System.out.println(name);

    }
}
