package com.david.net.tcp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * 服务端优化
 * @author david
 * @create 2019-04-24 22:37
 */
public class T06TCPFileuploadServerOptimised {
    public static void main(String[] args) throws IOException {
        String path="basic-13-net\\c_upload"+new Random().nextInt(1000)+".txt";

        ServerSocket ss=new ServerSocket(8888);

        while(true){
            new Thread(()->{
                try {
                    FileOutputStream fos=new FileOutputStream(path);
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
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();
        }


       // ss.close();
    }
}
