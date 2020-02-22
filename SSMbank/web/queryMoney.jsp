<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.Card" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/28
  Time: 13:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBank</title>
</head>
<body>
${sessionScope.userName}
用户，您的银行卡余额分别为
<c:forEach var="card" items="${requestScope.list}">
    账号为：${card.cardID}&nbsp;&nbsp;余额为：${card.cardMoney}<br>
</c:forEach>
<button onclick="window.location.href='welcome.jsp'">返回首页</button>
</body>
</html>
