package com.david.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;

/**
 * Jsoup常用解析方式
 * @author david
 * @create 2019-05-25 10:48
 */
public class J02JsoupApi {
    public static void main(String[] args) throws Exception{
        //除了加载xml文件的方式，还可以使用以下方式进行解析
        //1.xml字符串

        String xml="<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<students>\n" +
                "\t<student number=\"heima_0001\">\n" +
                "\t\t<name id=\"itcast\">\n" +
                "\t\t\t<xing>张</xing>\n" +
                "\t\t\t<ming>三</ming>\n" +
                "\t\t</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\t<student number=\"heima_0002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "\n" +
                "</students>";
        Document document = Jsoup.parse(xml);
        Elements elements = document.getAllElements();
        elements.stream().forEach((e)->{
            String nodeName = e.nodeName();
            System.out.println(nodeName);
        });
        System.out.println("------------------分割符-----------------------");
        //2.网络资源
        URL url=new URL("https://www.baidu.com/");
        Document d = Jsoup.parse(url, 10000);
        System.out.println(d);

    }
}
