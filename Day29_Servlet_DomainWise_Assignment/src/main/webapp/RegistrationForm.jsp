<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
</head>
<body>

<h2>Student Registration Form</h2>

<p >${error}</p>

<form action="register" method="post">

    Name: <input type="text" name="name"><br><br>

    Email: <input type="text" name="email"><br><br>

    Age: <input type="text" name="age"><br><br>

    Course:
    <select name="course">
        <option value="">--Select--</option>
        <option value="Java">Java</option>
        <option value="Python">Python</option>
        <option value="Web Development">Web Development</option>
    </select>

    <br><br>

    <input type="submit" value="Register">

</form>

</body>
</html>