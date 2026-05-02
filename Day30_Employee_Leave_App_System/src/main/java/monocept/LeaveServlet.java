package monocept;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/leave")
public class LeaveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
	    System.out.println("Servlet initialized");
	}

	@Override
	public void destroy() {
	    System.out.println("Servlet destroyed");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		// 1. Get data from form
        String name = request.getParameter("name");
        String id = request.getParameter("id");
        String dept = request.getParameter("dept");
        String type = request.getParameter("type");
        String daysStr = request.getParameter("days");
        String reason = request.getParameter("reason");
     // 2. Validation
        if (name.isEmpty() || id.isEmpty() || dept.isEmpty() || type == null
                || daysStr.isEmpty() || reason.length() < 10) {

//            response.sendRedirect("LeaveForm.html"); 
//            return;
        	RequestDispatcher rd = request.getRequestDispatcher("LeaveForm.html");
            rd.include(request, response);
            return;
        }

        int days = Integer.parseInt(daysStr);

        if (days < 1 || days > 10) {
//            response.sendRedirect("LeaveForm.html");
//            return;
        	RequestDispatcher rd = request.getRequestDispatcher("LeaveForm.html");
            rd.include(request, response);
            return;
        }

        // 3. Business Logic
        String message;
        if (days > 5) {
            message = "This leave request requires manager approval";
        } else {
            message = "This leave request can be processed normally";
        }

        // 4. Send data to JSP (Review Page)
        request.setAttribute("name", name);
        request.setAttribute("id", id);
        request.setAttribute("dept", dept);
        request.setAttribute("type", type);
        request.setAttribute("days", days);
        request.setAttribute("reason", reason);
        request.setAttribute("message", message);

        // 5. Forward to review page
        RequestDispatcher rd = request.getRequestDispatcher("review.jsp");
        rd.forward(request, response);
    }
 
	}


