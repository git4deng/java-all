package com.david.net.tcp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 文件上传案例服务器端:读取客户端上传的文件,保存到服务器的硬盘,给客户端回写"上传成功"

 明确:
 数据源:客户端上传的文件
 目的地:服务器的硬盘 d:\\upload\\1.jpg

 实现步骤:
 1.创建一个服务器ServerSocket对象,和系统要指定的端口号
 2.使用ServerSocket对象中的方法accept,获取到请求的客户端Socket对象
 3.使用Socket对象中的方法getInputStream,获取到网络字节输入流InputStream对象
 4.判断d:\\upload文件夹是否存在,不存在则创建
 5.创建一个本地字节输出流FileOutputStream对象,构造方法中绑定要输出的目的地
 6.使用网络字节输入流InputStream对象中的方法read,读取客户端上传的文件
 7.使用本地字节输出流FileOutputStream对象中的方法write,把读取到的文件保存到服务器的硬盘上
 8.使用Socket对象中的方法getOutputStream,获取到网络字节输出流OutputStream对象
 9.使用网络字节输出流OutputStream对象中的方法write,给客户端回写"上传成功"
 10.释放资源(FileOutputStream,Socket,ServerSocket)
 * @author david
 * @create 2019-04-24 21:57
 */
public class T04TCPFileuploadServer {
    public static void main(String[] args) throws IOException {
        String path="basic-13-net\\c_upload.txt";
        FileOutputStream fos=new FileOutputStream(path);
        ServerSocket ss=new ServerSocket(8888);
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();
        byte[] bytes=new byte[1024];
        int len=0;
        while((is.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        socket.getOutputStream().write("接收完毕".getBytes());
        fos.close();
        socket.close();
        ss.close();

    }
}
