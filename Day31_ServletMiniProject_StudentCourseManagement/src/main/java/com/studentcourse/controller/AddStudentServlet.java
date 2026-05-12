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

@WebServlet("/student/add")
public class AddStudentServlet extends HttpServlet {

    public void init() {
        System.out.println("AddStudentServlet Initialized");
    }

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

        RequestDispatcher rd =
            request.getRequestDispatcher(
                "Views/student-form.jsp"
            );

        rd.forward(request,response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
                          throws ServletException, IOException {

        String studentName =
                request.getParameter("studentName");

        String email =
                request.getParameter("email");

        String phone =
                request.getParameter("phone");

        int age =
            Integer.parseInt(
                request.getParameter("age")
            );

        String city =
                request.getParameter("city");

        if(age < 18) {

            request.setAttribute(
                "error",
                "Age must be 18 or above"
            );

            RequestDispatcher rd =
                request.getRequestDispatcher(
                    "Views/student-form.jsp"
                );

            rd.forward(request,response);

            return;
        }

        Student student = new Student();

        student.setStudentName(studentName);
        student.setEmail(email);
        student.setPhone(phone);
        student.setAge(age);
        student.setCity(city);

        StudentDAO dao = new StudentDAO();

        dao.addStudent(student);

        response.sendRedirect("students");
    }
}
