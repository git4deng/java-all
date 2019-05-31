package com.david.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup 快捷查询方式 选择器，与css选择器类似
 * @author david
 * @create 2019-05-25 10:58
 */
public class J05JsoupSelector {
    public static void main(String[] args) throws IOException {
        String path = J01Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //Document 继承至Element
        //1.标签名选择器
        Elements names = document.select("name");//通过标签名进行筛选
        System.out.println(names);

        //2.id选择器
        System.out.println("-----------------分割线1----------------");
        Elements ids = document.select("#itcast");
        System.out.println(ids);

        //3.标签选择器结合属性选择器
        System.out.println("-----------------分割线2----------------");
        Elements stus = document.select("student[number='heima_0001']");
        System.out.println(stus);

        //4.获取子标签
        System.out.println("-----------------分割线3----------------");
        Elements stu2 = document.select("student[number='heima_0001']> age");//字符串规则与css选择器类似
        System.out.println(stu2);


    }
}
