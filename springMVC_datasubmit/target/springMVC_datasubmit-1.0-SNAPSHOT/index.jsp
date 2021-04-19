<%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2021/3/9
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>1.单个数据提交</h2>
<form action="${pageContext.request.contextPath}/data/one.action" method="post">
    姓名：<input name="uname"><br>
    年龄：<input name="uage"><br>
    <input type="submit" value="提交">
</form>

<h2>2.对象封装数据提交</h2>
<form action="${pageContext.request.contextPath}/data/two.action" method="get">
    姓名：<input name="uname"><br>
    年龄：<input name="uage"><br>
    <input type="submit" value="提交">
</form>

<a href="${pageContext.request.contextPath}/data/three/中国/12.action">超链接1</a><br>
<a href="${pageContext.request.contextPath}/data/four.action?name=中国&age=18">超链接2</a><br>
<a href="${pageContext.request.contextPath}/data/five.action?name=中国&age=18">超链接3</a><br>
<a href="${pageContext.request.contextPath}/data/requestJsp.action">请求转发跳页面</a><br>
<a href="${pageContext.request.contextPath}/data/requestAction.action">请求转发跳action</a><br>
<a href="${pageContext.request.contextPath}/data/responseJsp.action">重定向跳页面</a><br>
<a href="${pageContext.request.contextPath}/data/responseAction.action">重定向跳Action</a><br>

<a href="${pageContext.request.contextPath}/mydata.action?age=18">取值</a>
</body>
</html>
