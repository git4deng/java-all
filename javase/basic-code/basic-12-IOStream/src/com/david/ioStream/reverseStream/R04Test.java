package com.david.ioStream.reverseStream;

import java.io.*;

/**
 * 练习：转换文件编码
 将GBK编码的文本文件，转换为UTF-8编码的文本文件。

 分析:
 1.创建InputStreamReader对象,构造方法中传递字节输入流和指定的编码表名称GBK
 2.创建OutputStreamWriter对象,构造方法中传递字节输出流和指定的编码表名称UTF-8
 3.使用InputStreamReader对象中的方法read读取文件
 4.使用OutputStreamWriter对象中的方法write,把读取的数据写入到文件中
 5.释放资源
 * @author david
 * @create 2019-04-23 22:43
 */
public class R04Test {
    public static final String PATH="basic-12-IOStream";
    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(new FileInputStream(PATH+"\\GBK.txt"),"GBK");
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream(PATH+"\\GBK2UTF8.txt"),"UTF-8");
        char[] cs=new char[1024];
        int len=0;
        while((len=isr.read(cs))!=-1){
            osw.write(cs,0,len);
            osw.flush();
        }
        isr.close();
        osw.close();
    }
}
