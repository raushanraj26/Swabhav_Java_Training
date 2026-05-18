package com.studentcourse.controller;


import java.io.IOException;

import com.studentcourse.dao.RegistrationDAO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updatestatus")
public class UpdateStatusServlet
        extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("loggedInUser") == null) {

            response.sendRedirect("login");

            return;
        }

        int registrationId =
            Integer.parseInt(
                request.getParameter("id")
            );

        request.setAttribute(
                "registrationId",
                registrationId
        );

        RequestDispatcher rd =
            request.getRequestDispatcher(
                "Views/update-status.jsp"
            );

        rd.forward(request,response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session =
                request.getSession(false);

        if(session == null ||
           session.getAttribute("loggedInUser") == null) {

            response.sendRedirect("login");

            return;
        }

        int registrationId =
            Integer.parseInt(
                request.getParameter(
                        "registrationId"
                )
            );

        String status =
                request.getParameter("status");

        RegistrationDAO dao =
                new RegistrationDAO();

        dao.updateRegistrationStatus(
                registrationId,
                status
        );

        response.sendRedirect(
                 "registrations"
        );
    }
}
