<%--
  Created by IntelliJ IDEA.
  User: Кроха
  Date: 23.11.2015
  Time: 20:58
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updating</title>
</head>
<body>
<h1>Update/Create shop information</h1>
    <p>Fill in new data:</p>
<form:form method="POST" action="submitUpdate" modelAttribute="shop">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="location">Location</form:label></td>
            <td><form:input path="location" /></td>
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
