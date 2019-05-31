package com.david.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Jsoup Element对象介绍以及常用API
 * @author david
 * @create 2019-05-25 10:58
 */
public class J04JsoupElement {
    public static void main(String[] args) throws IOException {
        String path = J01Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        /*
        Element：元素对象
            1. 获取子元素对象
                * getElementById​(String id)：根据id属性值获取唯一的element对象
                * getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
                * getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
                * getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合

            2. 获取属性值
                * String attr(String key)：根据属性名称获取属性值
            3. 获取文本内容
                * String text():获取所有字标签的纯文本内容
                * String html():获取标签体的所有内容(包括子标签的标签和文本内容)
         */
        Elements names = document.getElementsByTag("name");
        System.out.println(names.size());
        System.out.println("-----------------分割线----------------");
        //通过element对象获取子标签
        Element stu1 = document.getElementsByTag("student").get(0);
        Elements ele_name = stu1.getElementsByTag("name");
        System.out.println(ele_name);

        System.out.println("-----------------分割线----------------");
        //属性(属性名不区分大小写)
        String number = stu1.attr("number");
        System.out.println(number);
        //文本内容
        System.out.println("-----------------分割线----------------");
        String text = ele_name.get(0).text();
        String html = ele_name.get(0).html();
        System.out.println(text);
        System.out.println("-----------------分割线----------------");
        System.out.println(html);
    }
}
