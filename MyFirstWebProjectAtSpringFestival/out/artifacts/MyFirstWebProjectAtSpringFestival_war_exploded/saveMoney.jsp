<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/27
  Time: 15:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBank</title>
</head>
<body>
您正在为卡号为<br>
<%
    String id=(String)request.getAttribute("cardID");
    out.write(id);
    //request.setAttribute("cardID",id);
%><br>
存款
<form action="save" method="post">
    <input hidden="hidden" name="cardID" value="
<%
    out.write(id);
%>
">
    请输入金额<input type="text" name="money" value=""><br>
    <input type="submit" name="提交" value="提交">
</form>

</body>
</html>
