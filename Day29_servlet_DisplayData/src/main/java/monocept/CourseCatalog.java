
//� Assignment 3: Course Catalog Viewer (Education Domain) 
//Problem Statement: 
//Build a servlet /courses that shows courses based on department name. 
//Requirements: 
// Accept a parameter department (like CS, ME, EE). 
// Display relevant course list using if-else or map structure. 
// Show error if department doesn't exist. 
//Sample URL: 
//http://localhost:8080/courses?department=CS

package monocept;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
@WebServlet("/courses")
public class CourseCatalog extends HttpServlet {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String dept = request.getParameter("department");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		if (dept == null || dept.trim().isEmpty()) {
			out.println("<h3>Error: Department is required</h3>");
			return;
		}

		dept = dept.toUpperCase();

		Map<String, List<String>> coursesMap = new HashMap<>();

		coursesMap.put("CS", Arrays.asList("Data Structures", "Algorithms", "DBMS", "Operating System"));
		coursesMap.put("ME", Arrays.asList("Thermodynamics", "Fluid Mechanics", "Machine Design"));
		coursesMap.put("EE", Arrays.asList("Circuits", "Power Systems", "Control Systems"));

		List<String> courses = coursesMap.get(dept);

		if (courses == null) {
			out.println("<h3>Error: Department not found</h3>");
			return;
		}

		// display result
		out.println("<h2>Courses for " + dept + " Department</h2>");
		out.println("<ul>");

		for (String course : courses) {
			out.println("<li>" + course + "</li>");
		}

		out.println("</ul>");
	}

}
