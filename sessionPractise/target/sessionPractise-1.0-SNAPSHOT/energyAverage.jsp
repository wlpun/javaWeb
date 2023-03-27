<%--
  Created by IntelliJ IDEA.
  User: 16628
  Date: 2023-03-27
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>蚂蚁森林</title>
    <link rel="stylesheet" href="styles/energy.css">
</head>
<body>
    <jsp:include page="include_header.jsp"></jsp:include>

    <%--显示班级平均能朗数字（保留整数），展示文字和形式自定义--%>
    <%--html元素中签入JSP表达式模式--%>
    <p> <%= request.getAttribute("avg") %> </p>
    <jsp:include page="include_footer.jsp"></jsp:include>
</body>
</html>
