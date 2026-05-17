package com.studentcourse.controller;

import java.io.IOException;
import java.util.List;

import com.studentcourse.Model.Course;
import com.studentcourse.dao.CourseDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/courses")
public class ViewCoursesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

//        CourseDAO dao =
//                new CourseDAO();
//
//        List<Course> courseList =
//                dao.getAllCourses();
//
//        request.setAttribute(
//                "courseList",
//                courseList
//        );

        RequestDispatcher rd =
            request.getRequestDispatcher(
                "Views/course-list.jsp"
            );

        rd.forward(request,response);
    }
}