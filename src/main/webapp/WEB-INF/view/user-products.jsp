<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>
    User products
</h2>

    <ul>
        <c:forEach items="${products}" var="product">
            <li><b>Name</b>: ${product.name} <br><b>Price </b>: ${product.price} <br></li>
        </c:forEach>
    </ul>

<c:if test="${empty products}">
    <b>User do not have products yet</b>
</c:if>

<h1>${message}</h1>
<form action="/" method="GET">
    <input type="submit" value="Back to main page">
</form>
</body>
</html>