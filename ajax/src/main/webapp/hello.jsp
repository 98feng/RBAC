<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/2/27
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
<head>
    <script src="jquery/jquery-1.11.1-min.js"></script>

    <script type="text/javascript">
        $(function () {

            $("#submit").on("click",function(){
                $.ajax({
                    url:"one.do",
                    type:"post",
                    dataType:"json",
                    success:function (data) {
                        //data[{stu1},{name:?,age:?},{name:?,age:?},...]
                        // $("#msg").html(stu.name+"----"+stu.age+"<br>")
                        var html = "<tr>";
                        $.each(data,function (i,n) {
                            html += "<td>" + n.name + "</td>" + "<td>" + n.age + "</td><br>";
                        })
                        html += "</tr>"

                        $("#msg").html(html);
                    }
                })
            })
        })

    </script>>
</head>
<body>
    <input type="button" value="按钮" id="submit"/><br>
    <span id="msg" style="color:red"></span>
</body>
</html>
