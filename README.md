# database-project-term
数据库大作业（银行系统，本地版和联网版）

数据库结构如下

----
### desc:
<img src="数据库结构/数据库列表desc.png" style="zoom:20%">

### user表：
<img src="数据库结构/用户表select.PNG" style="zoom:20%">

### card表:
<img src="数据库结构/卡片表select.PNG" style="zoom:20%">

### tran表：
<img src="数据库结构/交易记录表select.PNG" style="zoom:20%">

几个数据库都是java写的，区别在于

# jdbd_atm副本
 这个原生的，没有任何框架（除了mysql驱动），是在本地上运行，没有javaWeb.
# springFestival
 这个只是加上了前端，servlet，没有ssh框架
# SSMBank
 加上了ssm框架。

__后面两个的数据库结构可能变化了，具体进入src->dao里面查看各个sql语句__
