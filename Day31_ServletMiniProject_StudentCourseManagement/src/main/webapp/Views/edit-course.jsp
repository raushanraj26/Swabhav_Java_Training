<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.studentcourse.Model.Course" %>

<%
Course course =
(Course) request.getAttribute("course");
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Edit Course</h2>

<form action="courseupdate" method="post">

    <input type="hidden"
           name="courseId"
           value="<%= course.getCourseId() %>">

    Course Name:
    <input type="text"
           name="courseName"
           value="<%= course.getCourseName() %>">

    <br><br>

    Duration:
    <input type="text"
           name="duration"
           value="<%= course.getDuration() %>">

    <br><br>

    Fees:
    <input type="number"
           name="fees"
           value="<%= course.getFees() %>">

    <br><br>

    Trainer Name:
    <input type="text"
           name="trainerName"
           value="<%= course.getTrainerName() %>">

    <br><br>

    <input type="submit"
           value="Update Course">

</form>

</body>
</html>