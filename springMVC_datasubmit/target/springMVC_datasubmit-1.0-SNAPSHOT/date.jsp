<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/3/11
  Time: 15:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>解决方案1</h2>
<form action="${pageContext.request.contextPath}/mydate.action" method="post">
    日期：<input type="date" name="mydate"><br>
    <input type="submit" value="提交">
</form>
<h2>解决方案2</h2>
<form action="${pageContext.request.contextPath}/mydate1.action" method="post">
    日期：<input type="date" name="mydate1"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
