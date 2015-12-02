<%--
  Created by IntelliJ IDEA.
  User: Кроха
  Date: 01.12.2015
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title> Shoplist </title>
</head>
<body BGCOLOR="#ffffcc">
<h2> products list </h2>
<table border="1">
    <c:forEach var="product" items="${products}">
        <tr>
            <td><a href="view?id=${product.id}">${product.name}</a></td>
            <td>${product.brand}</td>
            <td>${product.amount}</td>
            <td>${product.amount_type}</td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="create">Add a new product</a> </td>
    </tr>
</table>

</body>
</html>
