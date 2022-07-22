<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>
    Buy product
</h2>

<form action="/users/products" method="POST">
    <input type="text" name="userId" placeholder="User id">
    <input type="text" name="productId" placeholder="Product id">

    <input type="submit" value="Buy product">
</form>

<h1>${message}</h1>

<form action="/" method="GET">
    <input type="submit" value="Back to main page">
</form>
</body>
</html>