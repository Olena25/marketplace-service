<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>
    Welcome to Marketplace :)
</h2>

<h1>Displays</h1>

<br>
<form action="/users" method="GET">
    <input type="submit" value="Display Users">
</form>

<br>

<form action="/products" method="GET">
    <input type="submit" value="Display Products">
</form>

<br>

<form action="/users/products" method="GET">
    <input type="text" name="userId" placeholder="User id">
    <input type="submit" value="Display products for user">
</form>


<br>

<form action="/products/users" method="GET">
    <input type="text" name="productId" placeholder="Product id">
    <input type="submit" value="Display users by product">
</form>


<h1>Add</h1>

<form action="/add-user" method="GET">
    <input type="submit" value="Add User">
</form>

<br><br>

<form action="/add-product" method="GET">
    <input type="submit" value="Add Product">
</form>

<br><br>


<h1>Buy</h1>

<form action="/buy-product" method="GET">
    <input type="submit" value="Buy Product">
</form>



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