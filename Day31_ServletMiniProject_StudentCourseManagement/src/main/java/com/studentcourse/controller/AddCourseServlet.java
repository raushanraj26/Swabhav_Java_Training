package com.studentcourse.controller;


import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.exception.DAOException;
import com.studentcourse.Model.Course;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/course/add")
public class AddCourseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CourseDAO dao;

	@Override
	public void init() throws ServletException {

		dao = new CourseDAO();

		System.out.println("AddCourseServlet initialized via init()");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {

			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {

			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		String courseName = request.getParameter("courseName");
		String durationStr = request.getParameter("duration");
		String feesStr = request.getParameter("fees");
		String trainerName = request.getParameter("trainerName");

		courseName = (courseName != null) ? courseName.trim() : "";

		durationStr = (durationStr != null) ? durationStr.trim() : "";

		feesStr = (feesStr != null) ? feesStr.trim() : "";

		trainerName = (trainerName != null) ? trainerName.trim() : "";

		// Send values back
		request.setAttribute("courseName", courseName);
		request.setAttribute("duration", durationStr);
		request.setAttribute("fees", feesStr);
		request.setAttribute("trainerName", trainerName);

		String nameRegex = "^[A-Za-z ]{2,50}$";

		// Required validation
		if (courseName.isEmpty() || durationStr.isEmpty() || feesStr.isEmpty() || trainerName.isEmpty()) {

			request.setAttribute("errorMessage", "All fields are required");

			request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);

			return;
		}

		// Course name validation
		if (!courseName.matches(nameRegex)) {

			request.setAttribute("errorMessage", "Course name must contain only alphabets");

			request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);

			return;
		}

		// Trainer validation
		if (!trainerName.matches(nameRegex)) {

			request.setAttribute("errorMessage", "Trainer name must contain only alphabets");

			request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);

			return;
		}

		// Duration validation
		int duration;

		try {

			duration = Integer.parseInt(durationStr);

			if (duration <= 0) {

				request.setAttribute("errorMessage", "Duration must be greater than 0");

				request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);

				return;
			}

		} catch (NumberFormatException e) {

			request.setAttribute("errorMessage", "Duration must be a valid number");

			request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);

			return;
		}

		// Fees validation
		double fees;

		try {

			fees = Double.parseDouble(feesStr);

			if (fees <= 0) {

				request.setAttribute("errorMessage", "Fees must be greater than 0");

				request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);

				return;
			}

		} catch (NumberFormatException e) {

			request.setAttribute("errorMessage", "Fees must be a valid number");

			request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);

			return;
		}

		Course c = new Course();

		c.setCourseName(courseName);
		c.setDuration(duration);
		c.setFees(fees);
		c.setTrainerName(trainerName);

		try {

			boolean status = dao.addCourse(c);

			if (status) {

				response.sendRedirect(request.getContextPath() + "/courses");

			} else {

				request.setAttribute("errorMessage", "Unable to add course.");

				request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);
			}

		} catch (DAOException e) {

			request.setAttribute("errorMessage", e.getMessage());

			request.getRequestDispatcher("/WEB-INF/views/course-form.jsp").forward(request, response);
		}
	}
}
