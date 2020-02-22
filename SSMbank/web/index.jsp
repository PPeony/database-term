<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/24
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <script type="text/javascript" src="judgeNull.js"></script>


  <title>MyBankSystem</title>
</head>
  <body>
  <p id="flag">
    <c:if test="${requestScope.flag!=null}">
      <c:out value="用户名或者密码错误"/>
    </c:if>
  </p>
  <form action="login.do" method="post">
    <input type="text" id="userID" name="userID" value=""><br>
    <input type="text" id="password" name="password" value=""><br>
    <input type="submit" id="submit" name="login" value="登录" >
  </form>
  <script>
    var nameText = document.getElementById('userID');
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
