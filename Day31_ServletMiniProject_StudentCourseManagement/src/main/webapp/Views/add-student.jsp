<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Student</title>
</head>
<body>

<h2>Add Student</h2>

<form action="AddStudentServlet" method="post">

    Name:
    <input type="text" name="studentName" required>
    <br><br>

    Email:
    <input type="email" name="email" required>
    <br><br>

    Phone:
    <input type="text" name="phone" required>
    <br><br>

    Age:
    <input type="number" name="age" min="18" required>
    <br><br>

    City:
    <input type="text" name="city" required>
    <br><br>

    <input type="submit" value="Add Student">

</form>

</body>
</html>