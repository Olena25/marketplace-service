<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<h2>
    Add User
</h2>

<form action="/users" method="POST">
    <input type="text" name="firstName" placeholder="First name">
    <input type="text" name="lastName" placeholder="Last name">
    <input type="number" name="amountOfMoney" placeholder="Amount of money">

    <input type="submit" value="Add user">
</form>

<h1>${message}</h1>

<form action="/" method="GET">
    <input type="submit" value="Back to main page">
</form>
</body>
</html>