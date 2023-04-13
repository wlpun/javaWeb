<%--
  Created by IntelliJ IDEA.
  User: 16628
  Date: 2023-04-10
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <th></th>
        </tr>
        <c:forEach var="country" items="${countryList}">
            <tr>
                <td>${country.code}</td><td>${country.name}</td>
                <td>${country.surfaceArea}</td><td>${country.population}</td>
                <td><a href="${pageContext.request.contextPath}/GetCityServlet?countryCode=${country.code}">显示城市</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/searchCountry.html">重新查询</a>
</body>
</html>
