package com.david.ioStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * JDK7的新特性
     在try的后边可以增加一个(),在括号中可以定义流对象
     那么这个流对象的作用域就在try中有效
     try中的代码执行完毕,
     格式:
     try(定义流对象;定义流对象....){
        可能会产出异常的代码
     }catch(异常类变量 变量名){
        异常的处理逻辑
     }
 * @author david
 * @create 2019-04-22 23:08
 */
public class S02StreamJDK7 {
    public static void main(String[] args) {
        String path="basic-12-IOStream\\w04.txt";
        //将流对象定义在try后面的括号中，会自动把流对象释放,不用写finally
        try(FileWriter fw=new FileWriter(path,true);){
            for (int i = 0; i < 20; i++) {
                fw.write("计数器："+i);
                fw.write("\r\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    /**
     * 文件复制代码的优化一下
     */
    public static void copyFile(){
        long s = System.currentTimeMillis();

        String pathIn="basic-12-IOStream\\s01.txt";
        String pathOut="basic-12-IOStream\\s01_copy.txt";

        try(FileInputStream fis=new FileInputStream(pathIn);
            FileOutputStream fos=new FileOutputStream(pathOut);) {
            byte[] bytes=new byte[1024];
            int len=0;
            while((len=fis.read(bytes))!=-1){
                fos.write(bytes,0,len);
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        long e = System.currentTimeMillis();
        System.out.println("复制文件共耗时:"+(e-s)+"毫秒");
    }
}
