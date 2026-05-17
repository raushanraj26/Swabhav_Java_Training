package com.studentcourse.controller;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.Model.Course;

@WebServlet("/courseedit")
public class EditCourseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        int id =
            Integer.parseInt(
                request.getParameter("id")
            );

        CourseDAO dao =
                new CourseDAO();

        Course course =
                dao.getCourseById(id);

        request.setAttribute(
                "course",
                course
        );

        RequestDispatcher rd =
            request.getRequestDispatcher(
                "Views/edit-course.jsp"
            );

        rd.forward(request,response);
    }
}