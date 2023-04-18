<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <title>宠物商城</title>
    <style>
        .petbox{
            width: 600px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <h1>"宠物详情"</h1>
    <div class="petbox">
        <img src="${ctx}/petimg/${pet.photo}" width="200" height="250" />
        <p>${pet.title}</p>
        <p>${pet.descs}</p>
        <p>${pet.tag}</p>
        <p>价格：${pet.price}</p>
        <p>库存：${pet.stock}</p>
        <form action="${ctx}/AddToCartServlet" method="post">
            <p>
                数量：<input type="text" name="quantity" value="1">
                <input type="hidden" name="id" value="${pet.id}">
            </p>
            <p>
                <input type="submit" value="加入购物车">
                <a href="${ctx}/IndexServlet">返回首页</a>
            </p>
        </form>
    </div>
</body>
</html>