package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.exception.DAOException;
import com.studentcourse.Model.Student;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/student/add")
public class AddStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private StudentDAO studentDAO;

	@Override
	public void init() throws ServletException {
		studentDAO = new StudentDAO();
		System.out.println("AddStudentServlet initialized via init()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		String name = request.getParameter("studentName");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String ageStr = request.getParameter("age");
		String city = request.getParameter("city");

		// Trim values safely
		name = (name != null) ? name.trim() : "";
		email = (email != null) ? email.trim() : "";
		phone = (phone != null) ? phone.trim() : "";
		city = (city != null) ? city.trim() : "";

		// Send values back to JSP
		request.setAttribute("studentName", name);
		request.setAttribute("email", email);
		request.setAttribute("phone", phone);
		request.setAttribute("age", ageStr);
		request.setAttribute("city", city);

		// Regex patterns
		String nameRegex = "^[A-Za-z ]{2,50}$";
		String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.(com|in)$";
		String phoneRegex = "^[6-9]\\d{9}$";
		String cityRegex = "^[A-Za-z ]{2,50}$";

		// Required field validation
		if (name.isEmpty() || email.isEmpty() || phone.isEmpty() || ageStr == null || ageStr.trim().isEmpty()
				|| city.isEmpty()) {

			request.setAttribute("error", "All fields are required!");

			request.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(request, response);
			return;
		}

		// Name validation
		if (!name.matches(nameRegex)) {

			request.setAttribute("error", "Invalid name! Only letters and spaces allowed (2–50 chars).");

			request.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(request, response);
			return;
		}

		// Email validation
		if (!email.matches(emailRegex)) {

			request.setAttribute("error", "Invalid email format!");

			request.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(request, response);
			return;
		}

		// Phone validation
		if (!phone.matches(phoneRegex)) {

			request.setAttribute("error", "Invalid phone number! Must be 10 digits starting with 6-9.");

			request.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(request, response);
			return;
		}

		// Age validation
		int age;

		try {

			age = Integer.parseInt(ageStr);

			if (age < 18 || age > 100) {

				request.setAttribute("error", "Age must be between 18 and 100!");

				request.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(request, response);
				return;
			}

		} catch (NumberFormatException e) {

			request.setAttribute("error", "Age must be a valid number!");

			request.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(request, response);
			return;
		}

		// City validation
		if (!city.matches(cityRegex)) {

			request.setAttribute("error", "Invalid city name! Only letters and spaces allowed.");

			request.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(request, response);
			return;
		}

		// Create Student object
		Student student = new Student();

		student.setStudentName(name);
		student.setEmail(email);
		student.setPhone(phone);
		student.setAge(age);
		student.setCity(city);

		try {

			if (studentDAO.addStudent(student)) {

				response.sendRedirect(request.getContextPath() + "/students");

			} else {

				request.setAttribute("error", "Database insertion failure occurred.");

				request.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(request, response);
			}

		} catch (DAOException e) {

			request.setAttribute("error", e.getMessage());

			request.getRequestDispatcher("/WEB-INF/views/student-form.jsp").forward(request, response);
		}
	}

	@Override
	public void destroy() {
		System.out.println("AddStudentServlet destroyed via destroy()");
	}
}