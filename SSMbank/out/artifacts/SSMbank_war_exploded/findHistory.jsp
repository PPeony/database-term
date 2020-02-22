<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="domain.Trans" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/29
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBank</title>
</head>
<body>
${sessionScope.get("userName")}
用户，您的银行卡余额分别为<br/>
<c:forEach var="key" items="${requestScope.list}">
    卡号为：${key.cardID}&nbsp;交易方式为：${key.transType}&nbsp;
    交易金额为:${key.transMoney}&nbsp;交易时间为:${key.getDate()}<br>
</c:forEach>

<button onclick="window.location.href='welcome.jsp'">返回首页</button>

</body>
</html>
