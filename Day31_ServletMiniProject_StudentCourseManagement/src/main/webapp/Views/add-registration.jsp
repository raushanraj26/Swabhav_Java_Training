<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.studentcourse.Model.Student" %>
<%@ page import="com.studentcourse.Model.Course" %>

<%@ page import="com.studentcourse.dao.StudentDAO" %>
<%@ page import="com.studentcourse.dao.CourseDAO" %>

<%
    // Create DAO objects
    StudentDAO studentDAO = new StudentDAO();
    CourseDAO courseDAO = new CourseDAO();

    // Fetch data from database
    List<Student> studentList = studentDAO.getAllStudents();
    List<Course> courseList = courseDAO.getAllCourses();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Registration</title>
</head>

<body>

<h2>Add Registration</h2>

<form action="addregistration" method="post">

    <!-- Student Dropdown -->
    Student:

    <select name="studentId">

        <%
            for(Student student : studentList) {
        %>

        <option value="<%= student.getStudentId() %>">
            <%= student.getStudentName() %>
        </option>

        <%
            }
        %>

    </select>

    <br><br>

    <!-- Course Dropdown -->
    Course:

    <select name="courseId">

        <%
            for(Course course : courseList) {
        %>

        <option value="<%= course.getCourseId() %>">
            <%= course.getCourseName() %>
        </option>

        <%
            }
        %>

    </select>

    <br><br>

    <!-- Registration Date -->
    Registration Date:

    <input type="date" name="registrationDate">

    <br><br>

    <!-- Status -->
    Status:

    <select name="status">

        <option value="Active">Active</option>
        <option value="Completed">Completed</option>
        <option value="Cancelled">Cancelled</option>

    </select>

    <br><br>

    <input type="submit" value="Register">

</form>

</body>
</html>