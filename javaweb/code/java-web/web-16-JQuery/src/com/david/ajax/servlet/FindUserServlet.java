package com.david.ajax.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author david
 * @create 2019-06-11 22:30
 */
@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //设置响应的数据格式为json
        res.setContentType("application/json;charset=utf-8");
        String username = req.getParameter("username");
        Map<String,Object> result=new HashMap<>();
        if("david".equals(username)){
            result.put("userExsit",true);
            result.put("msg","用户名已经存在！");
        }else{
            result.put("userExsit",false);
            result.put("msg","用户名可用！");
        }
        //将结果转换成json字符串并绑定到输出流输出。
        ObjectMapper om=new ObjectMapper();
        om.writeValue(res.getWriter(),result);

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        this.doPost(req, res);
    }
}
