package com.david.net.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建BS版本TCP服务器
 * @author david
 * @create 2019-04-25 20:38
 */
public class T08TCPServerThread {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket=new ServerSocket(8080);

        while (true){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Socket accept = serverSocket.accept();
                        InputStream is = accept.getInputStream();

                        BufferedReader br = new BufferedReader(new InputStreamReader(is));
                        String firstLine =br.readLine();

                        String[] split = firstLine.split(" ");

                        String path= split[1].substring(1);

                        System.out.println("path:"+path);
                        FileInputStream fis=new FileInputStream(path);

                        OutputStream os = accept.getOutputStream();

                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());

                        os.write("\r\n".getBytes());

                        byte[] bytes=new byte[1024];
                        int len=0;
                        while((len=fis.read(bytes))!=-1){
                            os.write(bytes,0,len);
                        }

                        fis.close();
                        accept.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        //serverSocket.close();
    }
}
