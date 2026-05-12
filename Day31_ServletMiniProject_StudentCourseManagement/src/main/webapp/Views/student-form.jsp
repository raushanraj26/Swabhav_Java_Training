<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student-form</title>
</head>
<body>

<h2>Add Student</h2>

<p style="color:red;">
${error}
</p>

<form action="student/add" method="post">

    Name:
    <input type="text" name="studentName">

    <br><br>

    Email:
    <input type="email" name="email">

    <br><br>

    Phone:
    <input type="text" name="phone">

    <br><br>

    Age:
    <input type="number" name="age">

    <br><br>

    City:
    <input type="text" name="city">

    <br><br>

    <input type="submit" value="Add Student">

</form>

</body>
</html>