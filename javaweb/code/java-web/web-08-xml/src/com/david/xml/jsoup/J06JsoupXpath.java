package com.david.xml.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Jsoup 快捷查询方式 Xpath方法
 * @author david
 * @create 2019-05-25 10:58
 */
public class J06JsoupXpath {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = J01Jsoup.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");

        //3.根据document对象，创建JXDocument对象
        JXDocument jxDocument = new JXDocument(document);
        //4.1查询所有student标签
        List<JXNode> jxNodes = jxDocument.selN("//student");
        jxNodes.stream().forEach(System.out::println);
        System.out.println("-----------------分割线1----------------");
        List<JXNode> names = jxDocument.selN("//student/name");
        System.out.println(names);

        //4.3查询student标签下带有id属性的name标签
        System.out.println("-----------------分割线2----------------");
        List<JXNode> jxNodes3 = jxDocument.selN("//student/name[@id]");
        for (JXNode jxNode : jxNodes3) {
            System.out.println(jxNode);
        }

        //4.4查询student标签下带有id属性的name标签 并且id属性值为itcast
        System.out.println("-----------------分割线2----------------");
        List<JXNode> jxNodes4 = jxDocument.selN("//student/name[@id='itcast']");
        for (JXNode jxNode : jxNodes4) {
            System.out.println(jxNode);
        }


    }
}
