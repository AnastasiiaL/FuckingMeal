<%--
  Created by IntelliJ IDEA.
  User: Кроха
  Date: 01.12.2015
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product deleted</title>
</head>
<body>
<h1>You deleted a product:</h1>
<table border>
    <tr>
        <td>${product.name}</td>
        <td>${product.brand}</td>
        <td>${product.amount}</td>
        <td>${product.amount_type}</td>
    </tr>
    <tr>
        <td><a href="list">Ok!</a></td>
    </tr>
</table>
</body>
</html>
