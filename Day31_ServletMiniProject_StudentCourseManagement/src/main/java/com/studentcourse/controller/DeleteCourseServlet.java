package com.studentcourse.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.studentcourse.dao.CourseDAO;

@WebServlet("/coursedelete")
public class DeleteCourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        int courseId =
            Integer.parseInt(
                request.getParameter("id")
            );

        CourseDAO dao =
                new CourseDAO();

        dao.deleteCourse(courseId);

        response.sendRedirect( "courses"
        );
    }
}
