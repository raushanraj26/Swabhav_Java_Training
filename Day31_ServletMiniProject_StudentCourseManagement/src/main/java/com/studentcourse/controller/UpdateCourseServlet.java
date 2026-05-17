package com.studentcourse.controller;



import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.studentcourse.dao.CourseDAO;
import com.studentcourse.Model.Course;

@WebServlet("/courseupdate")
public class UpdateCourseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        int courseId =
            Integer.parseInt(
                request.getParameter("courseId")
            );

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

        course.setCourseId(courseId);
        course.setCourseName(courseName);
        course.setDuration(duration);
        course.setFees(fees);
        course.setTrainerName(trainerName);

        CourseDAO dao =
                new CourseDAO();

        dao.updateCourse(course);

        response.sendRedirect( "courses"
        );
    }
}
