<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/26
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">

    <script src="jquery/jquery-1.11.1-min.js"></script>

    <script type="text/javascript">
        <%--function asyncRequest() {--%>
        <%--    //1.创建xmlHttp对象--%>
        <%--    var xmlHttp = new XMLHttpRequest();--%>

        <%--    //2.绑定回调事件,会被初始化，发送请求，回传数据触发此事件--%>
        <%--    xmlHttp.onreadystatechange = function () {--%>

        <%--        alert("readyState=" + xmlHttp.readyState + ",status=" + xmlHttp.status);--%>
        <%--        //必须在条件满足的情况下进行数据渲染--%>
        <%--        if (xmlHttp.readyState == 4 && xmlHttp.status === 200) {--%>
        <%--            document.getElementById("myid").innerText = xmlHttp.responseText;--%>
        <%--        }--%>

        <%--    }--%>
        <%--    //3.xmlHttp对象的初始化--%>
        <%--    xmlHttp.open("post", "${pageContext.request.contextPath}/ajax.do");--%>

        <%--    //4.发送请求--%>
        <%--    xmlHttp.send();--%>

        $(function () {

            $("#height").val("");
            $("#weight").val("");

            $("#height").focus();


            $("#myid").on("click", function () {
                var height = $.trim($("#height").val());
                var weight = $.trim($("#weight").val());
                $.ajax({
                    url: "ajax.do",
                    data: {
                        "height": height,
                        "weight": weight
                    },
                    type: "post",
                    dataType: "json",
                    success: function (data) {
                        // data{success:"true/false",msg:"具体的消息"}
                        if (data.success) {
                            $("#msg").html(data.msg)
                        }
                    }
                })
            })
        })

    </script>
</head>
<body>
<p>发送ajax请求</p>
<div style="width:800px;height: 200px;background-color: red"></div>
<%--<a href="javascript:asyncRequest()">访问服务器</a>--%>
<input type="text" id="height">身高(米)<br>
<input type="text" id="weight">体重(千克)<br>
<input type="button" value="计算BMI" id="myid">等待服务器返回数据</input><br>
<span id="msg" style="color: red"></span>
<div style="width:800px;height: 200px;background-color: blue"></div>
</body>
</html>
