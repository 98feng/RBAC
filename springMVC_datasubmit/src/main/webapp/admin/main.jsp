<%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2021/3/9
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>main.jsp.........</h2>

requestObj=${requestObj}<br>
sessionObj=${sessionObj}<br>
ModelMapObj=${modelMapObj}
Model=${modelObj}<br>
Map=${mapObj}<br>
${param.age}<br>


<fmt:formatDate value="${mydate}" pattern="yyyy-MM-dd"/>

</body>
</html>
