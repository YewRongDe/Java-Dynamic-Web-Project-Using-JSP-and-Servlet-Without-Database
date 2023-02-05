

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.model.Student;

/**
 * Servlet implementation class StudentDetails
 */
@WebServlet("/StudentDetails")
public class StudentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
	throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>StudentServlet</title>");
			out.println("</head>");
			out.println("<body>");
			
			// List to hold Student objects
			ArrayList<Student> std = new ArrayList<Student>();
			
			std.add(new Student("Dep 1", "S1", "Ahmad", 35));
			std.add(new Student("Dep 1", "S2", "Abu", 70));
			std.add(new Student("Dep 1", "S3", "Ali", 60));
			std.add(new Student("Dep 1", "S4", "Amirah", 90));
			std.add(new Student("Dep 2", "S5", "AhChong", 30));
			std.add(new Student("Dep 3", "S6", "Bonnie", 32));
			std.add(new Student("Dep 3", "S7", "Siva", 70));
			std.add(new Student("Dep 3", "S8", "Muria", 20));
			
			
			Map<String, String> studentPass = new HashMap<String, String>();
			for (int i = 0; i < std.size(); i++) {
				if (!studentPass.containsKey(std.get(i).getDepartment())) {

					int countList = 0;
					double pass = 0;
					int sameDep = 0;
					int passStudent = 0;
					while (countList < std.size()) {

						if (std.get(i).getDepartment().equals(std.get(countList).getDepartment())) {
							sameDep++;
							if (std.get(countList).getMarks() >= 40) {
								passStudent++;
							}
						}
						countList++;
					}

					pass = (double) passStudent / sameDep * 100;
					String finalPass = "";
					
					//to check a double value has no decimal part
					if(pass % 1 == 0) {
						int p = (int)pass;
						finalPass = String.valueOf(p);
					}else {
						DecimalFormat df = new DecimalFormat("0.00");
						pass = Double.parseDouble(df.format(pass));
						finalPass = String.valueOf(pass);
					}
					
					studentPass.put(std.get(i).getDepartment(), finalPass);
				}
			}

			for (int i = 0; i < std.size(); i++) {
				for (Entry<String, String> entry : studentPass.entrySet()) {
					if (std.get(i).getDepartment().equals(entry.getKey())) {
						std.get(i).setPass(entry.getValue());
					}
				}
			}
		 
			
			// Setting the attribute of the request object
			// which will be later fetched by a JSP page
			
			//Student std = new Student("Dep 1", "S1", "35", "Ahmad");
			request.setAttribute("data", std);
			
			// Creating a RequestDispatcher object to dispatch
			// the request the request to another resource
			RequestDispatcher rd = 
			request.getRequestDispatcher("Welcome.jsp");
			
			// The request will be forwarded to the resource 
			// specified, here the resource is a JSP named,
			// "stdlist.jsp"
			rd.forward(request, response);
			out.println("</body>");
			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
