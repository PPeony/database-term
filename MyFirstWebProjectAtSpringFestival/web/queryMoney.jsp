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
<%
    String name=(String)session.getAttribute("name");
    out.write(name);
%>
用户，您的银行卡余额分别为
<%
    ArrayList<Card>list=new ArrayList<>();
    list=(ArrayList<Card>)request.getAttribute("list");
    for(Card card:list){
        out.write("<p>账号为");
        out.write(card.getCardID());
        out.write("&nbsp");
        out.write("余额为:");
        out.write(card.getCardMoney().toString());
        out.write("</p>");
    }
%>
<button onclick="javascript:history.back(-1);" value="">返回上一页</button><br>
<button onclick="window.location.href='welcome.jsp'">返回首页</button>
</body>
</html>
