<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int registrationId =
(Integer) request.getAttribute(
        "registrationId"
);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Status</title>
</head>

<body>

<h2>Update Registration Status</h2>

<form action="updatestatus"
      method="post">

<input type="hidden"
       name="registrationId"
       value="<%= registrationId %>">

Status:

<select name="status">

<option value="Active">
    Active
</option>

<option value="Completed">
    Completed
</option>

<option value="Cancelled">
    Cancelled
</option>

</select>

<br><br>

<input type="submit"
       value="Update Status">

</form>

</body>
</html>