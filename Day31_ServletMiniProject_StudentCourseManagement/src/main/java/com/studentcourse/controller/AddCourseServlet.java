package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.Model.Course;
import com.studentcourse.dao.CourseDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addcourseservlet")
public class AddCourseServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if(session == null ||session.getAttribute("loggedInUser") == null) {
            response.sendRedirect("login");
            return;
        }
        RequestDispatcher rd =  request.getRequestDispatcher( "Views/add-course.jsp"  );
        rd.forward(request,response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String courseName =
                request.getParameter("courseName");

        String duration =
                request.getParameter("duration");

        double fees =
            Double.parseDouble(
                request.getParameter("fees")
            );

        String trainerName =
                request.getParameter("trainerName");

        Course course =
                new Course();

        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setFees(fees);
        course.setTrainerName(trainerName);

        CourseDAO dao =
                new CourseDAO();

        dao.addCourse(course);

//        response.sendRedirect(
//                request.getContextPath() + "/courses"
//        );
        response.sendRedirect( "courses" );
    }
}