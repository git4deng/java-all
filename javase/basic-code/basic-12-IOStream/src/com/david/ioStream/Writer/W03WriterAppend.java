package com.david.ioStream.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 续写和换行
 续写,追加写:使用两个参数的构造方法
 FileWriter(String fileName, boolean append)
 FileWriter(File file, boolean append)
 参数:
 String fileName,File file:写入数据的目的地
 boolean append:续写开关 true:不会创建新的文件覆盖源文件,可以续写; false:创建新的文件覆盖源文件
 换行:换行符号
 windows:\r\n
 linux:/n
 mac:/r
 * @author david
 * @create 2019-04-22 22:24
 */
public class W03WriterAppend {
    public static void main(String[] args) throws IOException {
        String path="basic-12-IOStream\\w04.txt";
        FileWriter fw=new FileWriter(path,true);
            fw.write("david");
            fw.write("\r\n");

        for (int i = 0; i < 20; i++) {
            fw.write("计数器："+i);
            fw.write("\r\n");
        }
        fw.close();
    }
}
