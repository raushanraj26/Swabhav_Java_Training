<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
<h1>Admin Dashboard</h1>
<h3>
Welcome,
<%-- ${sessionScope.loggedInUser} --%>
<%-- ${session.getAttribute("loggedInUser")} --%>
${loggedInUser}
</h3>
<hr>

<a href="students">Manage Students</a>

<br><br>

<a href="courses">Manage Courses</a>

<br><br>

<a href="registrations">Manage Registrations</a>

<br><br>

<a href="logout">Logout</a>

</body>
</html>