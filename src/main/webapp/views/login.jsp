<%@ page language="java" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <title>Page Login</title>
</head>
<body>
<h1>Login</h1>
<h2>Cin chào,${name}</h2>
<form action="/login" method="POST">
    <div>
        <label>UserName</label>
        <input type="text" name="user">
    </div>
    <div>
        <label>Password</label>
        <input type="password" name="pass">
    </div>
    <div>
        <button>Submit</button>
    </div>
</form>
</body>
</html>