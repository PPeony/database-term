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
用户，您的银行卡余额分别为
<c:forEach var="key" items="${requestScope.list}">
    <c:out value="卡号为："/>${key.cardID}&nbsp;<c:out value="交易方式为："/>${key.transType}&nbsp;
    <c:out value="交易金额为:"/>${key.transMoney}&nbsp;<c:out value="交易时间为:"/>${key.date}这是一段文字<br>
</c:forEach>
<%--<%--%>
<%--    String name=(String)session.getAttribute("name");--%>
<%--    out.write(name);--%>
<%--%>--%>
<%--用户，您的银行卡余额分别为--%>
<%--<%--%>
<%--    ArrayList<Trans>list=new ArrayList<>();--%>
<%--    list=(ArrayList<Trans>)request.getAttribute("list");--%>
<%--    for(Trans trans:list){--%>
<%--        out.write("<p>卡号为");--%>
<%--        out.write(trans.getCardID());--%>
<%--        out.write("&nbsp");--%>
<%--        out.write("交易方式为:");--%>
<%--        out.write("&nbsp");--%>
<%--        out.write(trans.getTransType());--%>
<%--        out.write("交易金额为");--%>
<%--        out.write("&nbsp");--%>
<%--        out.write(trans.getTransMoney().toString());--%>
<%--        out.write("交易时间为");--%>
<%--        out.write("&nbsp");--%>
<%--        out.write(trans.getDate());--%>
<%--        out.write("</p>");--%>
<%--    }--%>
<%--%>--%>
<button onclick="javascript:history.back(-1);" value="">返回上一页</button><br>
<button onclick="window.location.href='welcome.jsp'">返回首页</button>

</body>
</html>
