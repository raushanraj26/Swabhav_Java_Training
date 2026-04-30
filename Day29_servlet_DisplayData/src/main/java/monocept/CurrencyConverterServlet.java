
//� Assignment 2: Currency Converter (Finance Domain) 
//Problem Statement: 
//Develop a servlet /convert that converts an amount from one currency to another using 
//static conversion rates. 
//Requirements: 
// Accept query parameters amount, from, and to. 
// Use hardcoded conversion rates (e.g., USD to INR = 83.0). 
// Validate parameters and show formatted result. 
//Sample URL: 
//http://localhost:8080/convert?amount=100&from=USD&to=INR


package monocept;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/convert")
public class CurrencyConverterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		
		//extract parameters(data coming fron CurrencyConverter.html file)
		String amount=request.getParameter("amount");
		String from=request.getParameter("from");
		String to=request.getParameter("to");
		
//		step-2
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//step3 validate input
		
		if (amount == null || from == null || to == null ||
			    amount.isEmpty() || from.isEmpty() || to.isEmpty()) {

			    out.println("<h3>Error: All fields are required</h3>");
			    return;
			}
		
		//Step4 Convert amount (String -> double)
		double amt;

		try {
		    amt = Double.parseDouble(amount);
		} catch (NumberFormatException e) {
		    out.println("<h3>Error: Invalid amount</h3>");
		    return;
		}
		
		
		//if we take input through text then these are helpful for validation. but we are taking input through dropdown so it doent make sense
//		from = from.toUpperCase();
//		to = to.toUpperCase();
		
		
		double rate = 0;

		if (from.equals("USD") && to.equals("INR")) {
		    rate = 83.0;
		}
		else if (from.equals("INR") && to.equals("USD")) {
		    rate = 1.0 / 83.0;
		}
		else if (from.equals("USD") && to.equals("EUR")) {
		    rate = 0.92;
		}
		else if (from.equals("EUR") && to.equals("USD")) {
		    rate = 1.0 / 0.92;
		}
		else if (from.equals(to)) {  //same currency  me convert nhi ho skta isiliye return 1
		    rate = 1.0;
		}
		else {
		    out.println("<h3>Error: Unsupported currency</h3>");
		    return;
		}
		
		
		//calculaate AMOUNT
		double result = amt * rate;
		
		
		out.println("<h2>Currency Conversion Result</h2>");
		out.println("<p>" + amt + " " + from + " = " + String.format("%.2f", result) + " " + to + "</p>");
		
		
		
		
		
	}

}
