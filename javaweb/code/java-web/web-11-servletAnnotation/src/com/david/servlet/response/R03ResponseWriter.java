package com.david.servlet.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 输出字符数据
 * @author david
 * @create 2019-05-28 21:24
 */
@WebServlet("/r03")
public class R03ResponseWriter extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("r03.............");
        //解决中文乱码问题，Tomcat默认编码是ISO-8859-1，这种方式是告诉浏览器使用哪种编码格式进行解码
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.write("hello response!");
        writer.write("\n");
        writer.write("因为输出流是reponse获取的，不需要手动去刷新缓存和关闭流的操作了，reponse相应完成后会自动完成该操作！");
    }
}
