package monocept;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/rating")
public class MovieRatingServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        // Step 1: Prepare response
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        // Step 2: Get parameter
	        String movieName = request.getParameter("movieName");

	        // Step 3: Validate
	        if (movieName == null || movieName.trim().isEmpty()) {
	            out.println("<h3>Error: Movie name is required</h3>");
	            return;
	        }

	        movieName = movieName.toLowerCase();

	        // Step 4: Hardcoded Data (Map)
	        Map<String, Map<String, Object>> movieMap = new HashMap<>();

	        // Movie 1
	        Map<String, Object> inception = new HashMap<>();
	        inception.put("rating", "8.8");
	        inception.put("genre", "Sci-Fi");
	        inception.put("reviews", Arrays.asList("Excellent", "Mind-blowing", "Masterpiece"));
	        movieMap.put("inception", inception);

	        // Movie 2
	        Map<String, Object> avatar = new HashMap<>();
	        avatar.put("rating", "7.9");
	        avatar.put("genre", "Action");
	        avatar.put("reviews", Arrays.asList("Visual treat", "Great VFX", "Good story"));
	        movieMap.put("avatar", avatar);

	        // Movie 3
	        Map<String, Object> interstellar = new HashMap<>();
	        interstellar.put("rating", "8.6");
	        interstellar.put("genre", "Sci-Fi");
	        interstellar.put("reviews", Arrays.asList("Emotional", "Scientific", "Amazing"));
	        movieMap.put("interstellar", interstellar);

	        // Step 5: Fetch movie
	        Map<String, Object> movie = movieMap.get(movieName);

	        if (movie == null) {
	            out.println("<h3>Error: Movie not found</h3>");
	            return;
	        }

	        // Step 6: Display result
	        out.println("<h2>Movie Details</h2>");
	        out.println("<p><b>Name:</b> " + movieName + "</p>");
	        out.println("<p><b>Rating:</b> " + movie.get("rating") + "</p>");
	        out.println("<p><b>Genre:</b> " + movie.get("genre") + "</p>");

	        out.println("<p><b>Reviews:</b></p>");
	        out.println("<ul>");

	        List<String> reviews = (List<String>) movie.get("reviews");
	        for (String review : reviews) {
	            out.println("<li>" + review + "</li>");
	        }

	        out.println("</ul>");
	    }
}