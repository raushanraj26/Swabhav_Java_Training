<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>

<h2>Exam Result</h2>

<hr>

<!-- Student Details -->
<p><b>Name:</b> ${name}</p>
<p><b>Roll Number:</b> ${roll}</p>

<hr>

<!-- Marks -->
<p><b>English's marks:</b> ${m1}</p>
<p><b>Hindi's marks:</b> ${m2}</p>
<p><b>Math's marks:</b> ${m3}</p>

<hr>

<!-- Result -->
<p><b>Total Marks:</b> ${total}</p>
<p><b>Percentage:</b> ${percentage}%</p>
<p><b>Status:</b> ${status}</p>

<hr>

<!-- Back Button -->
<a href="ExamForm.html">Go Back</a>

</body>
</body>
</html>