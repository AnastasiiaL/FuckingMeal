<%--
  Created by IntelliJ IDEA.
  User: Кроха
  Date: 07.12.2015
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value = "/css/style.css"/>"/>
    <title>ShopApp</title>
</head>
    <body>
        <header>
            <div><strong>Shop Application</strong></div>
        </header>
        <nav>
            <div class="navigation">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="">About</a></li>
                    <li><a href="">Contacts</a></li>
                </ul>
            </div>
        </nav>
        <main>
            <div class="buttons">
                <div class="button">
                    <img src="img/shops.jpg" width="220">
                    <p><input name="Shop" type="button" value="Find a shop"></p>
                </div>
                <div class="button">
                    <img src="img/products.jpg" width="220">
                    <p><input name="Product" type="button" value="Find a product"></p>
                </div>
            </div>

        </main>
        <footer>
            <div>
                <p><small>Copyright @Anastasiia Pushkina</small></p>
            </div>
        </footer>
    </body>
</html>
