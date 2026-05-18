<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.studentcourse.Model.Registration" %>
<%@ page import="com.studentcourse.dao.RegistrationDAO" %>

<%
    RegistrationDAO dao = new RegistrationDAO();

    List<Registration> registrationList =
            dao.getAllRegistrations();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration List</title>
</head>

<body>

<h2>Registration List</h2>

<a href="registrationadd">
    Add Registration
</a>

<br><br>

<table border="1" cellpadding="10">

<tr>
    <th>ID</th>
    <th>Student ID</th>
    <th>Course ID</th>
    <th>Registration Date</th>
    <th>Status</th>
    <th>Actions</th>
</tr>

<%
    for(Registration registration : registrationList) {
%>

<tr>

<td>
    <%= registration.getRegistrationId() %>
</td>

<td>
    <%= registration.getStudentId() %>
</td>

<td>
    <%= registration.getCourseId() %>
</td>

<td>
    <%= registration.getRegistrationDate() %>
</td>

<td>
    <%= registration.getStatus() %>
</td>

<td>

<a href="updatestatus?id=<%= registration.getRegistrationId() %>">
    Update Status
</a>

|

<a href=deleteregistration?id=<%= registration.getRegistrationId() %>">
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