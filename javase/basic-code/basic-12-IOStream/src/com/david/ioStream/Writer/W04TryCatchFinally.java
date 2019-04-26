package com.david.ioStream.Writer;

import javax.imageio.IIOException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 在jdk1.7之前使用try catch finally 处理流中的异常
     格式:
     try{
         可能会产出异常的代码
     }catch(异常类变量 变量名){
        异常的处理逻辑
     }finally{
        一定会指定的代码
        资源释放
    }
 * @author david
 * @create 2019-04-22 22:29
 */
public class W04TryCatchFinally {
    public static void main(String[] args) {
        String path="basic-12-IOStream\\w04.txt";
        FileWriter fw=null;
        try {
            fw=new FileWriter(path,true);
            for (int i = 0; i < 20; i++) {
                fw.write("计数器："+i);
                fw.write("\r\n");
            }
        }catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
             /*
                如果创建对象失败了,fw的默认值就是null,null是不能调用方法的,会抛出NullPointerException,
                需要增加一个判断,不是null在把资源释放
             */
            if(fw!=null)
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
