import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.Date;

public class MyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse responce) 		throws IOException{
		
		PrintWriter out = responce.getWriter();
		Date today = new Date();
		out.println("<html><body><h1 style='text-align : center'>MyServlet</h1><br/>"+today+"</body></html>");
		

	}

}