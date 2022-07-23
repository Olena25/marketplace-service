<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h1>
    Welcome to Marketplace :)
</h1>

<h3>Displays</h3>

<br>
<mark>Display all users &ensp;</mark>
<form action="/users" method="GET">
    <input type="submit" value="Display">
</form>

<br>

<mark>Display all products &ensp;</mark>

<form action="/products" method="GET">
    <input type="submit" value="Display">
</form>

<br>

<mark>Display products for user &ensp;</mark>

<form action="/users/products" method="GET">
    <input type="text" name="userId" placeholder="User id">
    <input type="submit" value="Display">
</form>

<br>

<mark>Display users who purchased product &ensp;</mark>

<form action="/products/users" method="GET">
    <input type="text" name="productId" placeholder="Product id">
    <input type="submit" value="Display">
</form>

<br>

<h3>Add</h3>

<mark>Add new user &ensp;</mark>

<form action="/add-user" method="GET">
    <input type="submit" value="Start">
</form>

<br>

<mark>Add new product &ensp;</mark>

<form action="/add-product" method="GET">
    <input type="submit" value="Start">
</form>

<br>

<mark>Buy product &ensp;</mark>

<form action="/buy-product" method="GET">
    <input type="submit" value="Start">
</form>

<br>

<h3>Delete</h3>


<mark>Delete user &ensp;</mark>

<%--JSP not allow to send DELETE--%>
<form action="/users/delete" method="POST">
    <input type="text" name="id" placeholder="User id">
    <input type="submit" value="Delete">
</form>

<h3>${userDeleteMessage}</h3>



<mark>Delete product &ensp;</mark>

<%--JSP not allow to send DELETE--%>
<form action="/products/delete" method="POST">
    <input type="text" name="productId" placeholder="Product id">
    <input type="submit" value="Delete">
</form>

<h3>${productDeleteMessage}</h3>



<c:if test="${!empty users}">
<h2>Users list</h2>
<ul>
    <c:forEach items="${users}" var="user">
        <li><b>Id</b>: ${user.id} <br><b>Fist name</b>: ${user.firstName} <br><b>Last name </b>: ${user.lastName} <br> <b>Amount of money </b>: ${user.amountOfMoney} $</li>
    </c:forEach>
</ul>
</c:if>

<br><br>

<c:if test="${!empty products}">
<h2>Products list</h2>
<ul>
    <c:forEach items="${products}" var="product">
        <li><b>Id</b>: ${product.id}<br><b>Name</b>: ${product.name}<br> <b>Price</b>: ${product.price} $</li>
    </c:forEach>
</ul>
</c:if>
</body>
</html>