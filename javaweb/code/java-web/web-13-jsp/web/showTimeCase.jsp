<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: David
  Date: 2019/5/30
  Time: 22:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>访问时间案例</title>
</head>
<body>
    <%
        //<%%>里面的代码就相当于servlet中的service方法中的代码
        response.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String now = sdf.format(date);

        Cookie[] cookies = request.getCookies();
        boolean flag=false;
        if(cookies!=null&&cookies.length>0) {
            for (Cookie c : cookies) {
                String name = c.getName();
                if ("lastTime".equals(name)) {
                    //证明有值
                    String value = c.getValue();
                    String message = "欢迎回来，您上次访问时间为：" + URLDecoder.decode(value,"utf-8");
                    c.setValue(URLEncoder.encode(now,"utf-8"));
                    response.addCookie(c);
                    try {
                        response.getWriter().write(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    flag=true;
                    break;
                }
            }
        }
        if (cookies == null || cookies.length == 0 || flag == false) {
            String message = "您好，欢迎您首次访问";
            Cookie cookie = new Cookie("lastTime", URLEncoder.encode(now,"utf-8"));
            //设置cookie存活时间
            cookie.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookie);
            response.getWriter().write(message);
        }
    %>
</body>
</html>
