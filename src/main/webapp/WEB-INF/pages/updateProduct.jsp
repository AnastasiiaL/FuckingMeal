<%--
  Created by IntelliJ IDEA.
  User: Кроха
  Date: 01.12.2015
  Time: 23:39
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updating</title>
</head>
<body>
<h1>Update/Create product information</h1>
<p>Fill in new data:</p>
<form:form method="POST" action="submitUpdate" modelAttribute="product">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="brand">Brand</form:label></td>
            <td><form:input path="brand" /></td>
        </tr>
        <tr>
            <td><form:label path="amount">Amount</form:label></td>
            <td><form:input path="amount" /></td>
        </tr>
        <tr>
            <td><form:label path="amount_type">Amount_type</form:label></td>
            <td><form:input path="amount_type" /></td>
        </tr>
        <form:hidden path="id" />
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>

