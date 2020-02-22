<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/30
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="judgeNull.js"></script>
    <script>
        function check() {
            var password=document.getElementById("newPassword").value;
            if(password.length<=6){
                alert("密码的长度不能小于六位");
            }
            else{

            document.form_name.action="judgeAccountPassword.do";
            }
        }
    </script>
    <title>MyBank</title>
</head>
<body>
<p  id="flag">
    <c:out value="${requestScope.flag}"/>
</p>
请输入原密码
<form action="" method="post" name="form_name">
    原密码：<input type="text" id="oldPassword" name="oldPassword" value=""><br>
    新密码：<input type="text" id="newPassword" name="newPassword" value="">
    <input type="submit" id="submit" name="submit" value="提交" onclick="check()">
</form>
</body>
</html>

