<%--
  Created by IntelliJ IDEA.
  User: 16628
  Date: 2023-04-13
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="EditCityServlet" method="post">
        <input type="hidden" name="id" value="${city.id}">
        城市名称：<input type="text" name="cityName" value="${city.name}"><br>
        区域名称：<input type="text" name="districtName" value="${city.district}"><br>
        人口数量：<input type="text" name="population" value="${city.population}"><br>
        <input type="submit">
    </form>
</body>
</html>
