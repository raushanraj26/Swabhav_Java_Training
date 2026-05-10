<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Admin Login</h2>
<p style="color:red;">
    ${error}
</p>

<form action="<%=request.getContextPath()%>/login-action" method="post">

    Username:
    <input type="text" name="username" required>

    <br><br>

    Password:
    <input type="password" name="password" required>

    <br><br>

    <input type="checkbox" name="remember">
    Remember Username

    <br><br>

    <input type="submit" value="Login">

</form>
</body>
</html>