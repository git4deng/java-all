package com.david.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup Document对象介绍以及常用API
 * @author david
 * @create 2019-05-25 10:58
 */
public class J03JsoupDocument {
    public static void main(String[] args) throws IOException {
        String path = J01Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //1.通过标签名获取元素
        Elements students = document.getElementsByTag("student");
        System.out.println(students);
        System.out.println("------分割符-------");

        //2.通过属性名获取元素
        Elements ids = document.getElementsByAttribute("id");
        System.out.println(ids);
        System.out.println("------分割符-------");
        //3获取指定属性值获取元素
        Elements eles = document.getElementsByAttributeValue("number", "heima_0001");
        System.out.println(eles);

        //4.通过id获取元素
        System.out.println("------分割符-------");
        Element itcast = document.getElementById("itcast");
        System.out.println(itcast);
    }
}
