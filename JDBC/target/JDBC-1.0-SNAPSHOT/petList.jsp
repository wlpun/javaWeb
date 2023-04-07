<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/7
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>利用 JDBC 查询宠物信息</title>
</head>
<body>
<h3>宠物列表</h3>
    <table>
        <tr>
            <th>编号</th><th>名称</th><th>价格</th>
        </tr>
        <c:forEach var="pet" items="${petList}" >
            <tr>
                <td>${pet.id}</td><td>${pet.title}</td><td>${pet.price}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
