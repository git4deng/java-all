package com.david.userlist.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @author david
 * @create 2019-06-08 22:09
 */
@WebFilter("/*")
public class SensitiveWordsFiter implements Filter {
    private List<String> words=new ArrayList<>();
    @Override
    public void init(FilterConfig config) throws ServletException {
        BufferedReader br=null;
        try {
            ServletContext servletContext = config.getServletContext();
            String path = servletContext.getRealPath("/WEB-INF/classes/sesitiveWords.txt");
            br=new BufferedReader(new FileReader(path));
            String line=null;
            if((line=br.readLine())!=null){
                words.add(line);
            }
            System.out.println(words);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //request.getParameter()
//        String[] parameterValues = request.getParameterValues();
//        Map<String, String[]> parameterMap = request.getParameterMap();
        //使用代理改变request参数
        ServletRequest req_proxy = (ServletRequest) Proxy.newProxyInstance(request.getClass().getClassLoader(), request.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if(method.getName().equals("getParameter")){
                    String value = (String) method.invoke(request, args);
                    if(value!=null && !"".equals(value)){
                        for (String word : words) {
                            if(value.contains(word)){
                                value.replaceAll(word,"**");
                            }
                        }
                    }
                    return value;

                }else if(method.getName().equals("getParameterValues")){
                    String[] values= (String[]) method.invoke(request,args);
                    System.out.println(Arrays.toString(values));
                    for (String value : values) {
                        if(value!=null && !"".equals(value)){
                            for (String word : words) {
                                if(value.contains(word)){
                                    value.replaceAll(word,"**");
                                }
                            }
                        }
                    }
                    System.out.println(Arrays.toString(values));
                    return null;
                }else if(method.getName().equals("getParameterMap")){
                    return null;
                }else{
                    //其它方法暂时不管
                    return method.invoke(request,args);
                }
            }
        });

        //注意此处传递代理对象
        filterChain.doFilter(req_proxy,response);
    }

    @Override
    public void destroy() {

    }
}
