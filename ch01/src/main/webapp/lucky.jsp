<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 16628
  Date: 2023-03-27
  Time: 16:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p> <%= request.getSession().getAttribute("username") %> </p>
    <form action="LuckyResultServlet" method="post">
        猜数字：<input type="text" name="n"> <br>
    </form>
</body>
</html>
