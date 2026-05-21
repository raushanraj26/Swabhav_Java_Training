package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.Model.Course;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/course/edit")
public class EditCourseServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CourseDAO courseDAO = new CourseDAO();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {

			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		int id = Integer.parseInt(request.getParameter("id"));

		request.setAttribute("course", courseDAO.getCourseById(id));

		request.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);

		if (session == null || session.getAttribute("loggedInUser") == null) {

			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}

		String idStr = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		String durationStr = request.getParameter("duration");
		String feesStr = request.getParameter("fees");
		String trainerName = request.getParameter("trainerName");

		courseName = (courseName != null) ? courseName.trim() : "";

		durationStr = (durationStr != null) ? durationStr.trim() : "";

		feesStr = (feesStr != null) ? feesStr.trim() : "";

		trainerName = (trainerName != null) ? trainerName.trim() : "";

		int id = Integer.parseInt(idStr);

		String nameRegex = "^[A-Za-z ]{2,50}$";

		Course c = new Course();

		c.setCourseId(id);
		c.setCourseName(courseName);
		c.setTrainerName(trainerName);

		// Required validation
		if (courseName.isEmpty() || durationStr.isEmpty() || feesStr.isEmpty() || trainerName.isEmpty()) {

			request.setAttribute("error", "All fields are required");

			request.setAttribute("course", c);

			request.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(request, response);

			return;
		}

		// Course name validation
		if (!courseName.matches(nameRegex)) {

			request.setAttribute("error", "Course name must contain only alphabets");

			request.setAttribute("course", c);

			request.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(request, response);

			return;
		}

		// Trainer validation
		if (!trainerName.matches(nameRegex)) {

			request.setAttribute("error", "Trainer name must contain only alphabets");

			request.setAttribute("course", c);

			request.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(request, response);

			return;
		}

		// Duration validation
		int duration;

		try {

			duration = Integer.parseInt(durationStr);

			if (duration <= 0) {

				request.setAttribute("error", "Duration must be greater than 0");

				request.setAttribute("course", c);

				request.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(request, response);

				return;
			}

		} catch (NumberFormatException e) {

			request.setAttribute("error", "Duration must be a valid number");

			request.setAttribute("course", c);

			request.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(request, response);

			return;
		}

		// Fees validation
		double fees;

		try {

			fees = Double.parseDouble(feesStr);

			if (fees <= 0) {

				request.setAttribute("error", "Fees must be greater than 0");

				request.setAttribute("course", c);

				request.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(request, response);

				return;
			}

		} catch (NumberFormatException e) {

			request.setAttribute("error", "Fees must be a valid number");

			request.setAttribute("course", c);

			request.getRequestDispatcher("/WEB-INF/views/course-edit.jsp").forward(request, response);

			return;
		}

		c.setDuration(duration);
		c.setFees(fees);

		courseDAO.updateCourse(c);

		response.sendRedirect(request.getContextPath() + "/courses");
	}
}