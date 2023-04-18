<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <title>宠物商城</title>
    <style>
        .petbox{
            width: 300px;
            padding: 0 20px;
            float: left;
        }
    </style>
</head>
<body>
    <h1>首页展示</h1>
    <c:forEach items="${petList}" var="pet">
        <div class="petbox">
            <img src="${ctx}/petimg/${pet.photo}" width="200px" height="250px" />
            <p>${pet.title}</p>
            <p>${pet.tag}</p>
            <p>${pet.price}</p>
            <p><a href="${ctx}/DetailServlet?id=${pet.id}">查看详情</a></p>
        </div>
    </c:forEach>
</body>
</html>