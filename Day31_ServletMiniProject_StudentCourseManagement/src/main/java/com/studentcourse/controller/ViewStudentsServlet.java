package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.Model.Student;
import com.studentcourse.dao.StudentDAO;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/students")
public class ViewStudentsServlet extends HttpServlet {

   protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
                         throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("loggedInUser") == null) {

            response.sendRedirect("login");
            return;
        }

//        StudentDAO stddao = new StudentDAO();
//
//        List<Student> studentList =
//                stddao.getAllStudents();
//
//        request.setAttribute(
//                "studentList",
//                studentList
//        );

        RequestDispatcher rd =
            request.getRequestDispatcher(
                "Views/student-list.jsp"
            );

        rd.forward(request,response);
    }
}
