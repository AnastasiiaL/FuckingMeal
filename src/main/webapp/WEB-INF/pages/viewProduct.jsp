<%--
  Created by IntelliJ IDEA.
  User: Кроха
  Date: 01.12.2015
  Time: 23:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ViewProduct</title>
</head>
<body>
<h1>The product information</h1>
<table border>
        <tr>
            <td>${product.name}</td>
            <td>${product.brand}</td>
            <td>${product.amount}</td>
            <td>${product.amount_type}</td>
        </tr>
    <tr>
        <td><a href="list">Back</a></td>
        <td><a href="update?id=${product.id}">Update</a></td>
        <td><a href="">Add a product</a></td>
        <td><a href="delete?id=${product.id}">Delete</a></td>
    </tr>
</table>
</body>
</html>
