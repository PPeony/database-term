<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/28
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBank</title>
</head>
<body>
<script>
    function check() {
        var id=document.getElementById("cardID").value;
        var password=document.getElementById("password").value;
        if(id.length!=16&&password.length!=6){
            alert('卡号应该为16位，密码为6位');
        }else{
            document.form_name.action="addCard.do";
        }
    }
</script>
<form action="" method="post" name="form_name">
    请输入银行卡号<input type="text" id="cardID" name="cardID" value="" ><br>
    请输入银行卡密码<INPUT type="password" id="password" name="cardPassword" value="">
    <input type="submit" value="提交" onclick="check()">
</form>

</body>
</html>
