package com.david.ioStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 文件复制练习:一读一写

 明确:
 数据源: c:\\1.jpg
 数据的目的地: d:\\1.jpg

 文件复制的步骤:
 1.创建一个字节输入流对象,构造方法中绑定要读取的数据源
 2.创建一个字节输出流对象,构造方法中绑定要写入的目的地
 3.使用字节输入流对象中的方法read读取文件
 4.使用字节输出流中的方法write,把读取到的字节写入到目的地的文件中
 5.释放资源
 * @author david
 * @create 2019-04-22 20:30
 */
public class S01FileCopy {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        String pathIn="basic-12-IOStream\\s01.txt";
        String pathOut="basic-12-IOStream\\s01_copy.txt";
        FileInputStream fis=new FileInputStream(pathIn);
        FileOutputStream fos=new FileOutputStream(pathOut);
        byte[] bytes=new byte[1024];
        int len=0;
        while((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        //释放资源(先关写的,后关闭读的;如果写完了,肯定读取完毕了)
        fos.close();
        fis.close();
        long e = System.currentTimeMillis();
        System.out.println("复制文件共耗时:"+(e-s)+"毫秒");
    }
}
