<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/27
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="judgeNull.js"></script>
    <title>MyBank</title>
</head>
<body>
<p  id="flag"><%
    String flag=(String)request.getAttribute("flag");
    if(flag!=null){
        out.write("银行卡号或者密码错误");
    }
%></p>
请输入银行卡号和密码
<form action="judgeCardPassword" method="post">
    <input hidden="hidden" name="target" value=<%
    String action=(String)request.getAttribute("target");
    if(action==null) System.out.println("action是空的");
        out.write("\"");
        out.write(action);
        out.write("\"");
    %>>
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
