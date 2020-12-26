
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginHandler
 */
public class LoginHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginHandler() {
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
	         
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_healthcare","root","Ujjw@l.16");
	         
	         Statement stmt=con.createStatement();
	         
	         ResultSet rs=stmt.executeQuery("select * from registration_info");
				
	         String email="";
	         String pass="";
	         String auth_id="";
				while(rs.next())
				{
					email=rs.getString("email");
					pass=rs.getString("password");
					auth_id=rs.getString("authentication");
					
					//out.println("<p>E-Mail:"+email+" Password:"+pass+" Authentication ID:"+auth_id+"</p>");
				}
	         
				 String nemail = request.getParameter("email");
				 String npass=request.getParameter("pass");
				 String nauth_id=request.getParameter("auth_id");
				 
				 if(nemail.equals(email) && npass.equals(pass) && nauth_id.equals(auth_id))
				 {
					 out.println("<h2>Login Successful!!</h2>");
				 }
				 else
				 {
					 out.println("<h2>Error in Login Try Again!!<h2>");
					 out.println("<a href='Login.jsp'>Login</a>");
					 
				 }
					 
				
				 
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
