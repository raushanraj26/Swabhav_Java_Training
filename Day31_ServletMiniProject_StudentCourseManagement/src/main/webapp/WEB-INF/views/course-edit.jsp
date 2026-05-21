<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.studentcourse.Model.Course"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Edit Course Specifications</title>
</head>

<body>

	<h2>Modify Course Parameters</h2>

	<%
	if (request.getAttribute("error") != null) {
	%>

	<div
		style="background-color: #f8d7da; color: #721c24; padding: 10px; margin-bottom: 15px; border: 1px solid #f5c6cb; border-radius: 4px;">

		<strong>Error:</strong>

		<%=request.getAttribute("error")%>

	</div>

	<%
	}

	Course c = (Course) request.getAttribute("course");

	if (c != null) {
	%>

	<form action="${pageContext.request.contextPath}/course/edit"
		method="post">

		<input type="hidden" name="courseId" value="<%=c.getCourseId()%>">

		Course Name: <input type="text" name="courseName"
			value="<%=c.getCourseName()%>" required> <br> <br>
		Duration: <input type="text" name="duration"
			value="<%=c.getDuration()%>" required> <br> <br>
		Fees: <input type="number" step="0.01" name="fees"
			value="<%=c.getFees()%>" required> <br> <br>
		Trainer Name: <input type="text" name="trainerName"
			value="<%=c.getTrainerName()%>" required> <br> <br>

		<button type="submit">Update Record</button>

		<a href="${pageContext.request.contextPath}/courses"> Cancel </a>

	</form>

	<%
	}
	%>

</body>
</html>