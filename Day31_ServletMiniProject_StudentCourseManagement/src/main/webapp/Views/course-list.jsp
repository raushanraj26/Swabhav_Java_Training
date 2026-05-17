<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.studentcourse.Model.Course" %>
<%@ page import="com.studentcourse.dao.CourseDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="addcourseservlet">
    Add Course
</a>
<%
CourseDAO dao = new CourseDAO();

List<Course> courseList = dao.getAllCourses();
%>

<table border="1">

<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Duration</th>
    <th>Fees</th>
    <th>Trainer</th>
    <th>Actions</th>
</tr>

<%--
<%
List<Course> courseList =
(List<Course>) request.getAttribute("courseList");

for(Course course : courseList) {
%>
--%>
<%
for(Course course : courseList) {
%>
<tr>

<td><%= course.getCourseId() %></td>

<td><%= course.getCourseName() %></td>

<td><%= course.getDuration() %></td>

<td><%= course.getFees() %></td>

<td><%= course.getTrainerName() %></td>

<td>

<a href="courseedit?id=<%= course.getCourseId() %>">
    Edit
</a>

|

<a href="coursedelete?id=<%= course.getCourseId() %>">
    Delete
</a>

</td>

</tr>

<%
}
%>

</table>
</body>
</html>