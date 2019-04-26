package com.david.file;

import java.io.File;

/**
 * 路径:
     绝对路径:是一个完整的路径
     以盘符(c:,D:)开始的路径
     c:\\a.txt
     C:\\Users\itcast\\IdeaProjects\\shungyuan\\123.txt
     D:\\demo\\b.txt
     相对路径:是一个简化的路径
     相对指的是相对于当前项目的根目录(F:\\learn\\java-all\\javase\\basic-code)
     如果使用当前项目的根目录,路径可以简化书写
 F:\\learn\\java-all\\javase\\basic-code\\123.txt-->简化为: 123.txt(可以省略项目的根目录)
     注意:
     1.路径是不区分大小写
     2.路径中的文件名称分隔符windows使用反斜杠,反斜杠是转义字符,两个反斜杠代表一个普通的反斜杠
 * @author david
 * @create 2019-04-20 14:46
 */
public class F02FileConstructor {
    public static void main(String[] args) {
        constructorMethodWithPath();
        constructorMethodWith2Params();
        constructorMethodWith2Params2();
    }
    /**
        File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
        参数:把路径分成了两部分
            File parent:父路径
            String child:子路径
        好处:
             父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
             父路径是File类型,可以使用File的方法对路径进行一些操作,再使用路径创建对象
     */
    private static void constructorMethodWith2Params2() {
        File parent = new File("c:\\");
        File file = new File(parent,"hello.java");
        System.out.println(file);//c:\hello.java
    }

    /**
     * File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
     参数:把路径分成了两部分
     String parent:父路径
     String child:子路径
     好处:
     父路径和子路径,可以单独书写,使用起来非常灵活;父路径和子路径都可以变化
     */
    private static void constructorMethodWith2Params() {
        String parent = "F:\\learn\\java-all\\javase\\basic-code";
        String child="a.txt";
        File f2=new File(parent,child);
        System.out.println(f2);//F:\learn\java-all\javase\basic-code\a.txt
    }

    /**
     * File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
     参数:
     String pathname:字符串的路径名称
     路径可以是以文件结尾,也可以是以文件夹结尾
     路径可以是相对路径,也可以是绝对路径
     路径可以是存在,也可以是不存在
     创建File对象,只是把字符串路径封装为File对象,不考虑路径的真假情况
     */
    private static void constructorMethodWithPath() {
        String path = "F:\\learn\\java-all\\javase\\basic-code";
        File f1 = new File(path);
        System.out.println(f1);//
    }
}
