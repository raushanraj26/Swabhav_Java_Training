package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.Model.Student;
import com.studentcourse.dao.StudentDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			response.sendRedirect("login");
			return;
		}
		 int id = Integer.parseInt(request.getParameter("id") );

		        StudentDAO dao = new StudentDAO();

		        Student student = dao.getStudentById(id);

		        request.setAttribute( "student",student);

		        RequestDispatcher rd =request.getRequestDispatcher( "/Views/edit-student.jsp" );

		        rd.forward(request,response);
//		 RequestDispatcher rd =request.getRequestDispatcher("Views/student-list.jsp" );
//		   rd.forward(request,response);
	}
	
}
