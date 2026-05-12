<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>
<%@ page import="com.studentcourse.Model.Student" %>
<%@ page import="com.studentcourse.dao.StudentDAO" %>
<%
    StudentDAO dao =
            new StudentDAO();

    List<Student> studentList =
            dao.getAllStudents();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student List</title>
</head>
<body>

<h2>Student List</h2>

<a href="AddStudentServlet">
    Add New Student
</a>

<br><br>

<table border="1" cellpadding="10">

<tr>

    <th>ID</th>
    <th>Name</th>
    <th>Email</th>
    <th>Phone</th>
    <th>Age</th>
    <th>City</th>
    <th>Actions</th>

</tr>
<%--
    List<Student> studentList =
        (List<Student>) request.getAttribute("studentList");

    for(Student student : studentList) {	
    }
    
--%>

<%
    for(Student student : studentList) {
%>

<tr>

    <td>
        <%= student.getStudentId() %>
    </td>

    <td>
        <%= student.getStudentName() %>
    </td>

    <td>
        <%= student.getEmail() %>
    </td>

    <td>
        <%= student.getPhone() %>
    </td>

    <td>
        <%= student.getAge() %>
    </td>

    <td>
        <%= student.getCity() %>
    </td>

    <td>

        <a href="edit-student.jsp?id=<%= student.getStudentId() %>">
            Edit
        </a>

        |

        <a href="DeleteStudentServlet?id=<%= student.getStudentId() %>">
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