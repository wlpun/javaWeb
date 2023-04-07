<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2023/4/7
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>利用 JDBC 显示宠物分类</title>
</head>
<body>
    <h3>宠物分类列表</h3>
    <table>
        <tr>
            <th>编号</th><th>名称</th><th>宠物列表</th>
        </tr>
        <%-- category 为每一次迭代时从集合中取得的对象变量，--%>
        <%-- categoryList 类型为列表，来自 Session 域--%>
        <c:forEach var="category" items="${categoryList}" >
            <tr>
                <td>${category.id}</td><td>${category.name}</td>
                <td><a href="${pageContext.request.contextPath}/
    GetPetServlet?category_id=${category.id}">查看</a></td>
            </tr>
        </c:forEach>
    </table>
    <hr>
    <a href="${pageContext.request.contextPath}
    /AddCategoryServlet?category_name=昆虫">新增分类</a>
</body>
</html>
