package com.studentcourse.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.studentcourse.dao.StudentDAO;
import com.studentcourse.Model.Student;

@WebServlet("/updateStudent")
public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        int studentId =Integer.parseInt(request.getParameter("studentId")
            );

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

        Student student =
                new Student();

        student.setStudentId(studentId);
        student.setStudentName(studentName);
        student.setEmail(email);
        student.setPhone(phone);
        student.setAge(age);
        student.setCity(city);

        StudentDAO dao =new StudentDAO();

        dao.updateStudent(student);

//        response.sendRedirect(request.getContextPath() + "/students" );
        response.sendRedirect("students" );
    }
}
