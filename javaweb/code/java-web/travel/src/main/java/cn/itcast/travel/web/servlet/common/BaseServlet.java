package cn.itcast.travel.web.servlet.common;

import cn.itcast.travel.domain.ResultInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author david
 * @create 2019-06-15 10:58
 */
public class BaseServlet extends HttpServlet {
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //完成请求分发操作
        String uri = req.getRequestURI();//travlet/user/add
        //截取最后的请求方法
        String methodName = uri.substring(uri.lastIndexOf("/") + 1);

        //注意此处关键问题，this指代这谁？谁调用这个方法就指代谁，而baseservlet不提供访问路径
        //都是其子类访问时，调用本方法 所以this代表其被调用的子类
        try {
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 输入json数据至浏览器
     * @param res
     * @param obj
     */
    public void putJson(HttpServletResponse res, Object obj) throws IOException {
        PrintWriter writer = res.getWriter();
        ObjectMapper mapper=new ObjectMapper();
        try {
            mapper.writeValue(writer,obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String getJsonString(Object obj) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(obj);
    }
}
