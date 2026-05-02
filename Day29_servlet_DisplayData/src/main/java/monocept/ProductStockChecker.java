
//� Assignment 5: Product Stock Checker (E-Commerce Domain) 
//Problem Statement: 
//Create a servlet /stock that takes productId as input and displays whether it is in stock. 
//Requirements: 
// Accept productId as a query parameter. 
// Use a map or list to simulate product inventory. 
// Return product name, availability, and stock count. 
//Sample URL: 
//http://localhost:8080/stock?productId=1023 

package monocept;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;

@WebServlet("/stock")
public class ProductStockChecker extends HttpServlet {
	// private Product product;
	// Simulated inventory (productId → details)
	private static Map<Integer, Product> inventory = new HashMap<>();

	// Static block to initialize data
	static {
		System.out.print("initialising in staic block");
		inventory.put(1, new Product("Milk", 5));
		inventory.put(2, new Product("Cake", 5));
		inventory.put(3, new Product("Cold Drink", 5));
		inventory.put(4, new Product("Biscuit", 5));
		inventory.put(5, new Product("Diary Milk", 5));
		inventory.put(6, new Product("Chocolate", 5));

	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Map<Integer,Product> inventory=new HashMap<>(); //jab v doPost run hoga hr brr new map create hoga
//		//if badd me data change krnge then data consistent nhi rhengea
//		inventory.put(1,new Product("Milk",5));
//		inventory.put(2,new Product("Cake",5));
//		inventory.put(3,new Product("Cold Drink",5));
//		inventory.put(4,new Product("Biscuit",5));
//		inventory.put(5,new Product("Diary Milk",5));
//		inventory.put(6,new Product("Chocolate",5));

		String pid = request.getParameter("productid");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
//		if (pid == null || pid.trim().isEmpty()) {
//			//out.println("<h3>Please provide productId</h3>");
//			response.sendRedirect("ProductChecker.html");  //same page redirect ho rha isiliye pta nhi chal rha 
//			return;
//
//		}
		
		
		if (pid == null || pid.trim().isEmpty()) {
			
			request.setAttribute("error", "Please select product");

			RequestDispatcher rd = request.getRequestDispatcher("ProductChecker.html");
			rd.forward(request, response);
		}
		
		
		int	 id = Integer.parseInt(pid);

		
		out.println("<html><body>");

		if (inventory.containsKey(id)) {

			Product p = inventory.get(id);

			out.println("<h2>Product Details</h2>");
			out.println("Name: " + p.getName() + "<br>");
			out.println("Stock Count: " + p.getStock() + "<br>");

			if (p.getStock() > 0) {
				out.println("Availability: In Stock");
			} else {
				out.println("Availability: Out of Stock");
			}

		} else {
			out.println("<h3>Product not found</h3>");
		}

		out.println("</body></html>");

	}

}
