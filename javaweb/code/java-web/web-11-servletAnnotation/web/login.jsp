<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <script>
        window.onload = function(){
            //1.获取图片对象
            var img = document.getElementById("checkCode");
            //2.绑定单击事件
            img.onclick = function(){
                //加时间戳
                var date = new Date().getTime();
                img.src = "/r05?"+date;
            }
        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <form action="/login" method="post">
        用户名：<input type="text" name="username" ><br>
        密码：<input type="password" name="pwd" ><br>
        <img id="checkCode" src="/r05" /><br>
        验证码：<input type="text" name="checkCode"><br>
        <input type="submit" value="登陆"><br>
    </form>

    <div><%=request.getAttribute("login_error")==null?"":request.getAttribute("login_error")%></div>
    <div><%=request.getAttribute("code_error")==null?"":request.getAttribute("code_error")%></div>
</body>
</html>
