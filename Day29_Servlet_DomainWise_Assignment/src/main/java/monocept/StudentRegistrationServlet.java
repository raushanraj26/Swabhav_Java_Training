package monocept;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/register")
public class StudentRegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String ageStr = request.getParameter("age");
		String course = request.getParameter("course");

		String error = null;

		// Validation
		if (name == null || name.trim().isEmpty()) {
			error = "Name cannot be empty";
		} else if (email == null || email.trim().isEmpty()) {
			error = "Email cannot be empty";
		} else if (ageStr == null || ageStr.trim().isEmpty()) {
			error = "Age is required";
		}

		if(!ageStr.trim().isEmpty() ) {
			int age = Integer.parseInt(ageStr);
		}
		if (age < 18) {
			error = "Age must be 18 or above";
		} else if (course == null || course.isEmpty()) {
			error = "Please select a course";
		}
		// If error -> go back to form
        if (error != null) {
            request.setAttribute("error", error);
            RequestDispatcher rd = request.getRequestDispatcher("RegistrationForm.jsp");
            rd.forward(request, response);
        } else {
            // Success -> send to result page
            request.setAttribute("name", name);
            request.setAttribute("email", email);
            request.setAttribute("age", ageStr);
            request.setAttribute("course", course);

            RequestDispatcher rd = request.getRequestDispatcher("RegistrationResult.jsp");
            rd.forward(request, response);
        }

	}

}
