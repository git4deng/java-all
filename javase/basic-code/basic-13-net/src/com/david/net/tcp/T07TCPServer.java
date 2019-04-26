package com.david.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建BS版本TCP服务器
 * @author david
 * @create 2019-04-25 20:38
 */
public class T07TCPServer {
    public static void main(String[] args) throws IOException {
        //
        ServerSocket serverSocket=new ServerSocket(8080);

        Socket accept = serverSocket.accept();
        InputStream is = accept.getInputStream();
//        byte[] bytes=new byte[1024];
//        int len=0;
//        while((len=is.read(bytes))!=-1){
//            System.out.println(new String(bytes,0,len));
//        }
        //GET /basic-13-net/web/index.html HTTP/1.1
        //把is网络字节输入流对象,转换为字符缓冲输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String firstLine =br.readLine();

        String[] split = firstLine.split(" ");
        //把路径前边的/去掉,进行截取 basic-13-net/web/index.html
        String path= split[1].substring(1);//basic-13-net/web/index.html
        //创建一个本地输入流
        System.out.println("path:"+path);
        FileInputStream fis=new FileInputStream(path);
        //获取网络输出流
        OutputStream os = accept.getOutputStream();
        // 写入HTTP协议响应头,固定写法
        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content-Type:text/html\r\n".getBytes());
        // 必须要写入空行,否则浏览器不解析
        os.write("\r\n".getBytes());

        //将获取到文件以字节流的方式输出
        byte[] bytes=new byte[1024];
        int len=0;
        while((len=fis.read(bytes))!=-1){
            System.out.println("len:"+len);
            os.write(bytes,0,len);
        }

        fis.close();
        accept.close();
        serverSocket.close();
    }
}
