<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2020/1/27
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBank</title>
    <script>
        //使用匿名函数方法
        function countDown(){

            var time = document.getElementById("Time");
            //alert(time.innerHTML);
            //获取到id为time标签中的内容，现进行判断
            if(time.innerHTML == 0){
                //等于0时清除计时
                window.location.href="index.jsp";
            }else{
                time.innerHTML = time.innerHTML-1;
            }
        }
        //1000毫秒调用一次
        window.setInterval("countDown()",1000);
    </script>
    <style>
        #Time,#p{
            font-size: 50px;
            text-align: center;
        }
    </style>
</head>
<body>
注册成功，即将返回首页
<p id="Time">3</p>
</body>
</html>
