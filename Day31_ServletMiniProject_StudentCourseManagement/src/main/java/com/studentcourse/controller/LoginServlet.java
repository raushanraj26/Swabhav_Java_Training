package com.studentcourse.controller;

import java.io.IOException;

import com.studentcourse.dao.AdminDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login-action")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");

        String password = request.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        AdminDAO dao = new AdminDAO();

        boolean status =
                dao.validateAdmin(username, password);

        if(status) {

            HttpSession session =
                    request.getSession();

            session.setAttribute(
                    "loggedInUser",
                    username
            );

            response.sendRedirect("dashboard");

        } else {

            request.setAttribute(
                    "error",
                    "Invalid Username or Password"
            );

            RequestDispatcher rd =
                    request.getRequestDispatcher(
                        "Views/Login.jsp"
                    );

            rd.forward(request, response);
        }
    }
}