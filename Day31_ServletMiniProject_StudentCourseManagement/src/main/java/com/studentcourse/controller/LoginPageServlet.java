//Starting of the project
//yaha se redirect hoga login.jsp jaha pe admin username and password fill krega the loginservlet handle krega


package com.studentcourse.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        response.sendRedirect("Views/Login.jsp");
//        RequestDispatcher rd =
//                request.getRequestDispatcher(
//                    "/WEB-INF/views/login.jsp"
//                );
//
//            rd.forward(request, response);

}
}