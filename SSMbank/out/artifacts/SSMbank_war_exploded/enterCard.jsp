<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/27
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <script src="judgeNull.js"></script>
    <title>MyBank</title>
</head>
<body>
<p  id="flag">
    <c:if test="${requestScope.flag!=null}">
    <c:out value="用户名或者密码错误"/>
    </c:if>
</p>
请输入银行卡号和密码
<form action="judgeCardPassword.do" method="post">
    <input hidden="hidden" name="target" value=${requestScope.target}>
    卡号：<input type="text" id="cardID" name="cardID" value=""><br>
    密码：<input type="text" id="password" name="password" value="">
    <input type="submit" id="submit" name="submit" value="提交">
</form>
<script >
    var nameText = document.getElementById('cardID');
    var passwordText=document.getElementById('password');
    var oBtn = document.getElementById('submit');
    oBtn.onclick = function () {
        isnull( nameText.value,passwordText.value ,1);
    }
</script>
</body>
</html>
