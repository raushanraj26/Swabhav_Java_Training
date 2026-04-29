package com.monocept;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class ServletLifeCycleDemo extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public void init() throws ServletException {
//        super.init();
        System.out.println("servlet init");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1> Hello Servlet Ji</h1>");
        out.println("</body>");
        out.println("</html>");

        out.close();
        System.out.println("request handled successfully");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
//        super.doPost(req, resp);
        PrintWriter out = resp.getWriter();
        out.println("post request");

        System.out.println("post request handling");
    }

    @Override
    public void destroy() {
//        super.destroy();
        System.out.println("servlet destroyed");
    }

}
