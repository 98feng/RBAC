<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/27
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <script src="jquery/jquery-1.11.1-min.js">

    </script>

    <script type="text/javascript">
        function good() {
            $.ajax({
                url:"one1.do",
                type:"post",
                success:function () {
                    alert(location.href)
                    $("#good").load(location.href+"#good")
                }
            })

        }
    </script>
</head>
<body>
<a href="javascript:good()">获取数据</a>
<div id="good">

    <table border="1">
        <tr>
            <th>学生姓名</th>
            <th>学生年龄</th>
        </tr>


        <c:forEach items="${map}" var="map">
            <tr>
                <td>${map.key.name}</td>
                <td>${map.value.age}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
