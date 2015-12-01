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
<h2> shops list </h2>
<table>
    <c:forEach var="shop" items="${shops}">
        <tr>
            <td><a href="view?id=${shop.id}">${shop.name}</a></td>
            <td>${shop.location}</td>
        </tr>
    </c:forEach>
    <tr>
        <td><a href="create">Add a new shop</a> </td>
    </tr>
</table>

</body>
</html>
