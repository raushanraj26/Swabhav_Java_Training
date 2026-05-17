<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Add Course</h2>

<form action="addcourseservlet" method="post">

    Course Name:
    <input type="text" name="courseName">

    <br><br>

    Duration:
    <input type="text" name="duration">

    <br><br>

    Fees:
    <input type="number" name="fees">

    <br><br>

    Trainer Name:
    <input type="text" name="trainerName">

    <br><br>

    <input type="submit" value="Add Course">

</form>

</body>
</html>