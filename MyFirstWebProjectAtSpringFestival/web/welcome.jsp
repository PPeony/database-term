<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/26
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBank</title>
</head>
<body>
    欢迎<%
        String name=(String)session.getAttribute("name");
        out.write(name);
    %>进入系统
    <form action="query" method="post">
        <input type="submit" name="查询余额" value="查询余额" >
    </form>

    <form action="addCard.jsp" method="post">
        <input type="submit" name="添加银行卡" value="添加银行卡">
    </form>

    <form action="midWay" method="post">
        <input hidden="hidden" name="target" value="saveMoney.jsp">
        <input type="submit" name="存款" value="存款" >
    </form>

    <form action="midWay" method="post">
        <input hidden="hidden" name="target" value="depositMoney.jsp">
        <input type="submit" name="取款" value="取款" >
    </form >
    <form action="midWay" method="post">
        <input hidden="hidden" name="target" value="findHistory.jsp">
        <input type="submit" name="查询历史" value="查询历史">
    </form>
    <form action="changePassword.jsp" method="post">
        <input type="submit" name="修改密码" value="修改账户密码">
    </form>
</body>
</html>
