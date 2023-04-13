<%--
  Created by IntelliJ IDEA.
  User: 16628
  Date: 2023-04-13
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="AddCityServlet" method="post">
        请选择国家编码：
        <select name="countryCode">
            <c:forEach var="country" items="${countryList}">
            <option value=${country.code}>${country.name}</option>
            </c:forEach>
        </select>
        <br>
        城市名称：<input type="text" name="cityName"><br>
        区域名称：<input type="text" name="districtName"><br>
        人口数量：<input type="text" name="population"><br>
        <input type="submit">
    </form>
</body>
</html>
