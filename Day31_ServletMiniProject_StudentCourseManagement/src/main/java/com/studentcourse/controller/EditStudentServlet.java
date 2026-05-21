package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.Model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student/edit")
public class EditStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private StudentDAO studentDAO = new StudentDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {

			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		int id = Integer.parseInt(request.getParameter("id"));

		Student s = studentDAO.getStudentById(id);

		request.setAttribute("student", s);

		request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {

			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		String idStr = request.getParameter("studentId");
		String name = request.getParameter("studentName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String ageStr = request.getParameter("age");
		String city = request.getParameter("city");

		// Trim safely
		name = (name != null) ? name.trim() : "";
		email = (email != null) ? email.trim() : "";
		phone = (phone != null) ? phone.trim() : "";
		city = (city != null) ? city.trim() : "";

		int id = Integer.parseInt(idStr);

		// Regex patterns
		String nameRegex = "^[A-Za-z ]{2,50}$";
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.(com|in)$";
		String phoneRegex = "^[6-9]\\d{9}$";
		String cityRegex = "^[A-Za-z ]{2,50}$";

		// Create object for sending back to JSP
		Student s = new Student();

		s.setStudentId(id);
		s.setStudentName(name);
		s.setEmail(email);
		s.setPhone(phone);
		s.setCity(city);

		// Required field validation
		if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || ageStr == null || ageStr.trim().isEmpty()
				|| city.isEmpty()) {

			request.setAttribute("error", "All fields are required!");

			request.setAttribute("student", s);

			request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
			return;
		}

		// Name validation
		if (!name.matches(nameRegex)) {

			request.setAttribute("error", "Invalid name! Only letters and spaces allowed.");

			request.setAttribute("student", s);

			request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
			return;
		}

		// Email validation
		if (!email.matches(emailRegex)) {

			request.setAttribute("error", "Invalid email format!");

			request.setAttribute("student", s);

			request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
			return;
		}

		// Phone validation
		if (!phone.matches(phoneRegex)) {

			request.setAttribute("error", "Invalid phone number! Must be 10 digits starting with 6-9.");

			request.setAttribute("student", s);

			request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
			return;
		}

		// Age validation
		int age;

		try {

			age = Integer.parseInt(ageStr);

			if (age < 18 || age > 100) {

				request.setAttribute("error", "Age must be between 18 and 100!");

				request.setAttribute("student", s);

				request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
				return;
			}

		} catch (NumberFormatException e) {

			request.setAttribute("error", "Age must be a valid number!");

			request.setAttribute("student", s);

			request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
			return;
		}

		s.setAge(age);

		// City validation
		if (!city.matches(cityRegex)) {

			request.setAttribute("error", "Invalid city name! Only letters and spaces allowed.");

			request.setAttribute("student", s);

			request.getRequestDispatcher("/WEB-INF/views/student-edit.jsp").forward(request, response);
			return;
		}

		// Update student
		studentDAO.updateStudent(s);

		response.sendRedirect(request.getContextPath() + "/students");
	}
}