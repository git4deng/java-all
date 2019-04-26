package com.david.ioStream.reverseStream;

import java.io.FileReader;
import java.io.IOException;

/**
 * FileReader可以读取IDE默认编码格式(UTF-8)的文件
 FileReader读取系统默认编码(中文GBK)会产生乱码
 * @author david
 * @create 2019-04-23 22:00
 */
public class R01FileReader {
    public static final String PATH="basic-12-IOStream";
    public static void main(String[] args) throws IOException {
        FileReader fr=new FileReader(PATH+"\\GBK.txt");
       char[] cs=new char[1024];
        int len=0;
        while((len=fr.read(cs))!=-1){
            //�����GBK��ʽ�������ַ���Ӵ��������������
            System.out.println(new String(cs,0,len));
        }
        fr.close();
    }
}
