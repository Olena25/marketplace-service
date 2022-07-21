<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>
    Add Product
</h2>

<form action="/products" method="POST">
    <input type="text" name="name" placeholder="Product name">
    <input type="number" name="price" placeholder="Product price">

    <input type="submit" value="Add product">
</form>

<h1>${message}</h1>

<form action="/" method="GET">
    <input type="submit" value="Back to main page">
</form>

</body>
</html>