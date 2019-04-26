package com.david.ioStream.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 *  字符输出流写数据的其他方法
     - void write(char[] cbuf)写入字符数组。
     - abstract  void write(char[] cbuf, int off, int len)写入字符数组的某一部分,off数组的开始索引,len写的字符个数。
     - void write(String str)写入字符串。
     - void write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
 * @author david
 * @create 2019-04-22 22:17
 */
public class W03FileWriterOtherMethod {
    public static void main(String[] args) throws IOException {
        String path="basic-12-IOStream\\w03.txt";
        FileWriter fw=new FileWriter(path);
        //写字符数组
        String str1="您好！";
        fw.write(str1.toCharArray());
        //write(char[] cbuf, int off, int len)
        String str2="您好世界！";
        char[] chars = str2.toCharArray();
        fw.write(chars,0,chars.length);
        //void write(String str)写入字符串。
        String str3="您好明天！";
        fw.write(str3);
        //write(String str, int off, int len) 写入字符串的某一部分,off字符串的开始索引,len写的字符个数。
        String str4="明天您好！";
        fw.write(str4,0,5);

        fw.close();//关闭的同时将数据刷新到硬盘中去
    }
}
