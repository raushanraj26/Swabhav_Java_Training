package com.studentcourse.controller;



import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;
import com.studentcourse.Model.Registration;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addregistration")
public class AddRegistrationServlet
        extends HttpServlet {

    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        int studentId =
            Integer.parseInt(
                request.getParameter("studentId")
            );

        int courseId =
            Integer.parseInt(
                request.getParameter("courseId")
            );

        String registrationDate =
                request.getParameter(
                        "registrationDate"
                );

        String status =
                request.getParameter("status");

        Registration registration =
                new Registration();

        registration.setStudentId(studentId);

        registration.setCourseId(courseId);

        registration.setRegistrationDate(
                registrationDate
        );

        registration.setStatus(status);

        RegistrationDAO dao =
                new RegistrationDAO();

        dao.addRegistration(registration);

        response.sendRedirect(
                
                "registrations"
        );
    }
}