package monocept;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/display")
public class DisplayServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// Fetch data
//		                         take from name="fullname" 
        String name = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phone = request.getParameter("number");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");

        // Print output
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h2>User Data</h2>");
        out.println("Name: " + name + "<br>");
        out.println("Email: " + email + "<br>");
        out.println("Phone: " + phone + "<br>");
        out.println("Gender: " + gender + "<br>");
        out.println("Address: " + address + "<br>");
    }
		
	}

