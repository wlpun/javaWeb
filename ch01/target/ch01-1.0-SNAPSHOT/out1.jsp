<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/3/24
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    HttpSession sessio = request.getSession();
    Object name = sessio.getAttribute("name");
    out.println(name);
%>
</body>
</html>
