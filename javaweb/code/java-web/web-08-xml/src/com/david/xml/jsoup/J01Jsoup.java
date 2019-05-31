package com.david.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Joup快速入门
 * @author david
 * @create 2019-05-25 10:26
 */
public class J01Jsoup {
    public static void main(String[] args) throws IOException {
        String path = J01Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //Elements 继承至List里面存的就是Element对象
        Elements elements = document.getElementsByTag("name");
        String name = elements.get(0).text();//
        System.out.println("name:"+name);

        elements.stream().forEach(System.out::println);


    }
}
