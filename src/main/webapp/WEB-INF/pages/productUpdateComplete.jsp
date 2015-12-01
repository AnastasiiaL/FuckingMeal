<%--
  Created by IntelliJ IDEA.
  User: Кроха
  Date: 01.12.2015
  Time: 23:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updated information</title>
</head>
<body>
<h1>Updated product information</h1>
<p>Product name: ${product.name}</p>
<p>Product brand: ${product.brand}</p>
<p>Product amout: ${product.amount}</p>
<p>Product amount_type: ${product.amount_type}</p>
<a href="list">Ok!</a>
<a href="update?id=${id}">Change it</a>
</body>
</html>
