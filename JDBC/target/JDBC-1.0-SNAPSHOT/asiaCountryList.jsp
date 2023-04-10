<%--
  Created by IntelliJ IDEA.
  User: 16628
  Date: 2023-04-09
  Time: 9:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="style">
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>编码</th>
            <th>名称</th>
            <th>面积</th>
            <th>人口</th>
        </tr>
        <c:forEach var="country" items="${countryArrayList}">
            <tr>
                <td>${country.code}</td><td>${country.name}</td>
                <td>${country.surfaceArea}</td><td>${country.population}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
