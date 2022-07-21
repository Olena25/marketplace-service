<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>
    Welcome to Marketplace :)
</h2>

<form action="/users" method="GET">
    <input type="submit" value="Display Users">
</form>

<br><br>

<form action="/products" method="GET">
    <input type="submit" value="Display Products">
</form>

<br><br>

<form action="/add-user" method="GET">
    <input type="submit" value="Add User">
</form>

<br><br>

<form action="/add-product" method="GET">
    <input type="submit" value="Add Product">
</form>

<c:if test="${!empty users}">
<h2>Users list</h2>
<ul>
    <c:forEach items="${users}" var="user">
        <li>${user}</li>
    </c:forEach>
</ul>
</c:if>

<br><br>

<c:if test="${!empty products}">
<h2>Products list</h2>
<ul>
    <c:forEach items="${products}" var="product">
        <li>${product}</li>
    </c:forEach>
</ul>
</c:if>
</body>
</html>