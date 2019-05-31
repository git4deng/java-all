package com.david.servlet.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * 获取请求参数的通用方法(获取参数的通用方法)
 * @author david
 * @create 2019-05-26 15:51
 */
@WebServlet("/s06")
public class S06RequestGetParameters extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        //解决post中文乱码(get在tomcat的配置文件中设置,tomcat8已经解决get中文乱码的问题)
        req.setCharacterEncoding("utf-8");

        System.out.println("post method....");
        String name = req.getParameter("name");
        System.out.println(name);
        //
        String[] hobbies = req.getParameterValues("hobby");
        Arrays.stream(hobbies).forEach(System.out::println);

        Enumeration<String> names = req.getParameterNames();
        while (names.hasMoreElements()){
            String s = names.nextElement();
            String parameter = req.getParameter(s);
            System.out.println(s+"------>"+ parameter);
        }
        System.out.println("-------------分割符-----------");
        Map<String, String[]> parameterMap = req.getParameterMap();
        Set<String> strings = parameterMap.keySet();
        strings.stream().forEach((key) ->{
            System.out.println(key+"=======>"+parameterMap.get(key).toString());
        });



    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("get method....");
//        String name = req.getParameter("name");
//        System.out.println(name);

        this.doPost(req,response);
    }
}
