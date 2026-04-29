package monocept;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/weather")
public class Whether extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		// Step 1: Get parameter
	    String city = request.getParameter("city");

	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    // Step 2: Validate city
	    if (city == null || city.trim().isEmpty()) {
	        out.println("<h3>Error: City name cannot be empty</h3>");
	        return;
	    }

	    // Step 3: Convert to lowercase for safe comparison
	    city = city.toLowerCase();

	    String temp = "";
	    String humidity = "";
	    String forecast = "";

	    // Step 4: Hardcoded logic
	    switch (city) {
	        case "delhi":
	            temp = "35°C";
	            humidity = "60%";
	            forecast = "Sunny";
	            break;

	        case "gurugram":
	            temp = "34°C";
	            humidity = "55%";
	            forecast = "Hot";
	            break;

	        case "hyderabad":
	            temp = "32°C";
	            humidity = "70%";
	            forecast = "Cloudy";
	            break;

	        case "noida":
	            temp = "33°C";
	            humidity = "65%";
	            forecast = "Clear";
	            break;

	        default:
	            // Step 5: Invalid city
	            out.println("<h3>Error: Invalid city name</h3>");
	            return;
	    }

	    // Step 6: Display result
	    out.println("<h2>Weather Report</h2>");
	    out.println("<p>City: " + city + "</p>");
	    out.println("<p>Temperature: " + temp + "</p>");
	    out.println("<p>Humidity: " + humidity + "</p>");
	    out.println("<p>Forecast: " + forecast + "</p>");
	}

}
