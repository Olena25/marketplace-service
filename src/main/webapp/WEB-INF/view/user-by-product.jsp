<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>
    Users found by product
</h2>

<c:if test="${!empty product}">
<h1>Product:  </h1>
<br>
    <b> Id:</b> ${product.id} <br>
    <b>Name</b>: ${product.name} <br>
    <b>Price </b>: ${product.price} <br>
</c:if>

<h1>Users: <br></h1>
    <ul>
        <c:forEach items="${users}" var="user">
            <li>
                <b>Id</b>: ${user.id} <br>
                <b>Fist name</b>: ${user.firstName} <br>
                <b>Last name </b>: ${user.lastName} <br>
                <b>Amount of money </b>: ${user.amountOfMoney} $
            </li>
        </c:forEach>
    </ul>

<c:if test="${empty users && !empty product}">
    <b>This product was not purchased yet</b>
</c:if>

<h1>${message}</h1>
<form action="/" method="GET">
    <input type="submit" value="Back to main page">
</form>
</body>
</html>