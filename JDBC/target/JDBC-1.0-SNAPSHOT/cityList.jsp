<%--
  Created by IntelliJ IDEA.
  User: 16628
  Date: 2023-04-13
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <th>编号</th>
            <th>名称</th>
            <th>行政区</th>
            <th>人口</th>
            <th></th>
        </tr>
        <c:forEach var="city" items="${cityList}">
            <tr>
                <td>${city.id}</td>
                <td>${city.name}</td>
                <td>${city.district}</td>
                <td>${city.population}</td>
                <td><a href="${pageContext.request.contextPath}/GetCityByIdServlet?id=${city.id}">修改城市</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
