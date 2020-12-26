

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
public class RegistrationHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html; charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	 
	      // Write the response message, in an HTML page
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Echo Servlet</title></head>");
	         out.println("<body><h2>You have entered</h2>");
	         
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_healthcare","root","Ujjw@l.16");
	         
	         Statement stmt = con.createStatement();
	         
	         // Name
	         String name = request.getParameter("name");
	         if (name == null) {
	        	 System.out.println("Name is missing!");
	         }
	         else {
	        	 out.println("<p>Name: " + name + "</p>");
	         }
	      // E-mail
	         String email=request.getParameter("email");
	         if(email==null)
	         {
	        	 System.out.println("E-mail is missing!!");
	         }
	         else
	         {
	        	 out.println("<p>E-mail: " + email + "</p>");
	         }
	         
	         //Password
	         String password = request.getParameter("pass");
	         if (password == null) {
	        	 System.out.println("Password is missing!!");
	         }
	         else {
	        	 out.println("<p>Password: " + password + "</p>");
	         }
	         
	         //Gender 
	         String gender = request.getParameter("gender");
	         if (gender == null) {
	             System.out.println("Please enter your gender!!");
	          } else if (gender.equals("m")) {
	             out.println("<p>Gender: male</p>");
	          } else {
	             out.println("<p>Gender: female</p>");
	          }
	         
	      // Age
	         String age = request.getParameter("age");
	         if (age == null) 
	         {
	            System.out.println("Please enter your age!!");
	         } 
	         else 
	         {
	            out.println("<p>Age: " +age+ "</p>");
	         }
	         
	         String id=name.substring(0,3)+'@'+age;
	      
	        	 out.println("<p>Authentication ID: " + id + "</p>");
	         
	      // Retrieve the value of the query parameter "secret" (from hidden field)
	         String secret = request.getParameter("secret");
	         out.println("<p>Secret: " + secret + "</p>");
	      // Hyperlink "BACK" to input page
	        out.println("<a href='Registration.jsp'>BACK</a>");
	 
	         out.println("</body></html>");
	         
	         String insert_query = "insert into registration_info values ('"+name+"', '"+email+"', '"+password+"' , "+age+", '"+id+"','"+gender+"')";
	    
	         int record = stmt.executeUpdate(insert_query);
	         
	         if(record == 1) {
	        	 	out.println("<h2>Registered Successfully!!</h2>");
	         }else {
	        	 out.println("<h2>Error in registration!!<h2>");
	         }
	         
	         out.println("<a href='Login.jsp'>Login</a>");
	         out.println("</body></html>");
	         
	      } catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 	catch (SQLException p) {
			p.printStackTrace();
		} 
	      finally 
	      {
	          out.close(); 
	      }
	}

}
