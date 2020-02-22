<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/24
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script type="text/javascript" src="judgeNull.js"></script>


  <title>MyBankSystem</title>
</head>
  <body>

  <p  id="flag"><%
    String flag=(String)request.getAttribute("flag");
    if(flag!=null){
      out.write("用户名或者密码错误");
    }
  %></p>
  <form action="judgeLogin" method="post">
    <input type="text" id="name" name="name" value=""><br>
    <input type="text" id="password" name="password" value=""><br>
    <input type="submit" id="submit" name="login" value="登录" >
  </form>
  <script>
    var nameText = document.getElementById('name');
    var passwordText=document.getElementById('password');
    var oBtn = document.getElementById('submit');
    oBtn.onclick = function () {
      console.log("调用了函数");
      isnull( nameText.value,passwordText.value,1 );
    }
  </script>
    <input type="button" name="register" value="注册" onclick="window.location.href='register.jsp'" ><br>

  </body>
</html>
