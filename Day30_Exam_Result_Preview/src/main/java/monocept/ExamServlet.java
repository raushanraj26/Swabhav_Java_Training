package monocept;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/preview")
public class ExamServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
		//get data
		String name=request.getParameter("name");
		String RollNo=request.getParameter("rollno");
		String Marks1=request.getParameter("m1");
		String Marks2=request.getParameter("m2");
		String Marks3=request.getParameter("m3");
		if(name.trim().isEmpty()|| RollNo.trim().isEmpty() || Marks1.trim().isEmpty() || Marks2.trim().isEmpty() || Marks3.trim().isEmpty() ) {
			response.sendRedirect("ExamForm.html");
			return;
		}
		
		//parse string to integer
		int m1 = Integer.parseInt(Marks1);
	   int m2 = Integer.parseInt(Marks2);
	   int m3 = Integer.parseInt(Marks3);
	   
	   //range validation
	   if (m1 < 0 || m1 > 100 ||
			    m2 < 0 || m2 > 100 ||
			    m3 < 0 || m3 > 100) {

			    response.sendRedirect("ExamForm.html");
			    return;
			}
	   
	   // Calculation
	    int total = m1 + m2 + m3;
	    double percentage = total / 3.0;

	    // Result status
	    String status;

	    if (percentage >= 75) {
	        status = "Distinction";
	    } else if (percentage >= 60) {
	        status = "First Class";
	    } else if (percentage >= 40) {
	        status = "Pass";
	    } else {
	        status = "Fail";
	    }

	    //Pass data to JSP
	    request.setAttribute("name", name);
	    request.setAttribute("roll", RollNo);
	    request.setAttribute("m1", m1);
	    request.setAttribute("m2", m2);
	    request.setAttribute("m3", m3);
	    request.setAttribute("total", total);
	    request.setAttribute("percentage", percentage);
	    request.setAttribute("status", status);

	    //  Forward to result.jsp
	    RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
	    rd.forward(request, response);
	   
	   
	   
		
		
	}

}
