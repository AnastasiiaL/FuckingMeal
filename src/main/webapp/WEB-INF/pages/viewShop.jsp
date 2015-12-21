<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Кроха
  Date: 23.11.2015
  Time: 0:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ViewShop</title>
</head>
<body>
<h1>The shop information</h1>
<ul>
    <li><p><b>Shop Name: ${shop.name}</b>
    </p></li>
    <li><p><b>Shop location: ${shop.location}</b>
    </p></li>
</ul>
<table border="1">
    <c:forEach var="product" items="${shop.products}">
        <tr>
            <td><a href="view?id=${product.product.id}">${product.product.name}</a></td>
            <td>${product.product.brand}</td>
            <td>${product.product.amount}</td>
            <td>${product.product.amount_type}</td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="product/create">Add a new product</a> </td>
    </tr>
</table>
<a href="list">Back</a>
<a href="update?id=${shop.id}">Update</a>
<a href="delete?id=${shop.id}">Delete</a>
</body>
</html>
