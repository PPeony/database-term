<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/27
  Time: 13:46
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
        var account=document.getElementById("account").value;
        var name=document.getElementById("name").value;
        var idCard=document.getElementById("idCard").value;
        var password=document.getElementById("password").value;
        var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        var regName =/^[\u4e00-\u9fa5]{2,4}$/;
        if(!regName.test(name)){
            alert('真实姓名填写有误');
        }else if(account.length<=6) {
            alert("账号不应该小于六位");
        }else if(password.length<=6){
            alert("密码应至少大于六位");
        }else if(reg.test(idCard) === false){
            alert("身份证输入不合法");
        }else{
            document.form_name.action="register";
        }
    }
</script>
<form action="" method="post" name="form_name">
    请输入账号&nbsp&nbsp&nbsp&nbsp：<input id="account" name="账号" type="text" value=""><br>
    请输入名字&nbsp&nbsp&nbsp&nbsp：<input id="name" name="名字" type="text" value=""><br>
    请输入账号密码：<input id="password" name="密码" type="text" value=""><br>
    请输入身份证号：<input id="idCard" name="身份证号" type="text" value=""><br>
    <input type="submit" name="提交" onclick="check()">

</form>

</body>
</html>
