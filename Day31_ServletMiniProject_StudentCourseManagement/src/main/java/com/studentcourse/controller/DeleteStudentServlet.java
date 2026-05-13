package com.studentcourse.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.studentcourse.dao.StudentDAO;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        int studentId =
            Integer.parseInt(
                request.getParameter("id")
            );

        StudentDAO dao =
                new StudentDAO();

        dao.deleteStudent(studentId);

//        response.sendRedirect(
//                request.getContextPath() + "/students"
//        );
        response.sendRedirect("students");
    }
}