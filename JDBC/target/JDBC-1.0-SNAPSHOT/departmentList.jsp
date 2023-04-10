<%--
  Created by IntelliJ IDEA.
  User: 16628
  Date: 2023-04-09
  Time: 9:51
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
            <th>department_no</th>
            <th>department_name</th>
        </tr>
        <c:forEach var="department" items="${departmentArrayList}">
            <tr>
                <td>${department.dept_no}</td>
                <td>${department.dept_name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
