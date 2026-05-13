<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.studentcourse.Model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>
</head>
<body>

<%
Student student =
(Student) request.getAttribute("student");
%>

<h2>Edit Student</h2>

<form action="updateStudent" method="post">

    <input type="hidden"
           name="studentId"
           value="<%= student.getStudentId() %>">

    Name:
    <input type="text"
           name="studentName"
           value="<%= student.getStudentName() %>">

    <br><br>

    Email:
    <input type="email"
           name="email"
           value="<%= student.getEmail() %>">

    <br><br>

    Phone:
    <input type="text"
           name="phone"
           value="<%= student.getPhone() %>">

    <br><br>

    Age:
    <input type="number"
           name="age"
           value="<%= student.getAge() %>">

    <br><br>

    City:
    <input type="text"
           name="city"
           value="<%= student.getCity() %>">

    <br><br>

    <input type="submit"
           value="Update Student">

</form>

</body>

</html>