

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationEditor
 */
public class RegistrationEditor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationEditor() {
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
	      try {
		         out.println("<!DOCTYPE html>");
		         out.println("<html><head>");
		         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
		         out.println("<title>Echo Servlet</title></head>");
		         
		         Class.forName("com.mysql.cj.jdbc.Driver");
		         
		         Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/online_healthcare","root","Ujjw@l.16");
		         
		         Statement stmt=con.createStatement();
		         String mail = request.getParameter("oemail");
		         String mail2 = request.getParameter("nemail");
		         
		         String update_query="update registration_info set email='"+mail2+"' where email='"+mail+"' ";
		         int recordu=stmt.executeUpdate(update_query);
		         if(recordu==1) {
		        	 out.println("<h2>Update Successful!!</h2>");
		        	 out.println("<a href='Login.jsp'>Login</a>");
		         }
		         else {
		        	 out.println("<h2>Error Email not found Try Again!!<h2>");
					 out.println("<a href='ChooseSpecialist.jsp'>Back</a>");
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
