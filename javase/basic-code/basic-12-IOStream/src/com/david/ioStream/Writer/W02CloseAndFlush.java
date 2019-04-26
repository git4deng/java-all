package com.david.ioStream.Writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * flush方法和close方法的区别
 - flush ：刷新缓冲区，流对象可以继续使用。
 - close:  先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了
 * @author david
 * @create 2019-04-22 22:13
 */
public class W02CloseAndFlush {
    public static void main(String[] args) throws IOException {
        String path="basic-12-IOStream\\w02.txt";
        FileWriter fw=new FileWriter(path);
        fw.write(97);
        fw.flush();
        fw.write(98);//刷新缓存区后流还能继续使用
        fw.close();
        fw.write(99);//会报错  java.io.IOException: Stream closed
    }
}
