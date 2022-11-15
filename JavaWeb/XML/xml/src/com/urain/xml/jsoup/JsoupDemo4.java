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
 * @description: Element 对象功能
 * @version: 1.0
 */
public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        // 获取Document文档对象
        // 获取student.xml的path
        String path = JsoupDemo4.class.getClassLoader().getResource("student.xml").getPath();
        // 获取Document对象
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 通过Document对象获取所有的name标签
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements);

        System.out.println("----------------------------------");

        // 通过Element对象获取子标签对象
        Element element_student = document.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());

        // 获取student对象的属性值
        String number = element_student.attr("Number");
        System.out.println(number);

        // 获取文本内容
        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println("text = " + text);
        System.out.println("----------------------------------");
        System.out.println(html);
    }
}
