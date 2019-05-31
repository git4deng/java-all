package com.david.servlet.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author david
 * @create 2019-05-29 22:35
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        ServletContext context = request.getServletContext();
        String realPath = context.getRealPath("/img/"+fileName);
        System.out.println(realPath);
        //????????
        String agent = request.getHeader("user-agent");
        System.out.println("user-agent:"+agent);
        fileName=DownLoadUtils.getFileName(agent,fileName);



        //?????content-type ?????????
        response.setHeader("content-type",context.getMimeType(fileName));
        //?????content-disposition ??????
        response.setHeader("content-disposition","attachment;filename="+fileName);

        File f=new File(realPath);
        InputStream is=new FileInputStream(f);
        ServletOutputStream os = response.getOutputStream();
        byte[] buffer=new byte[1024*10];
        int len=0;
        if((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        is.close();
    }
}
