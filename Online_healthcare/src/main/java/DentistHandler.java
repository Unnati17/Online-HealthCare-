

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
 * Servlet implementation class DentistHandler
 */
public class DentistHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DentistHandler() {
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
		doGet(request, response);
		
		response.setContentType("text/html; charset=UTF-8");
	      // Allocate a output writer to write the response message into the network socket
	      PrintWriter out = response.getWriter();
	 
	      // Write the response message, in an HTML page
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Echo Servlet</title></head>");
	         out.println("<body><h2>APPOINTEMENT SUMMARY</h2>");
	         
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_healthcare","root","Ujjw@l.16");
	         
	         Statement stmt = con.createStatement();
	         
	         out.println("<h2>Hostipal : Max Hospital</h2>");
	         out.println("<h3>Doctor's Name : Dr. Dipti</h3>");
	         
	         String specialist="Dr. Dipti";
	         
	         String date = request.getParameter("Date");
	        
	        	 out.println("<p><h3>Date: " +date + "</h3></p>");
	         
	         String time=request.getParameter("selectbox");
	     
	        	 out.println("<p><h3>Time: " + time + "</h3></p>");
	        	 
	        	 String datetime=date+time;
	     
	        	 ResultSet rs=stmt.executeQuery("select * from login");
	        	 String customer="";
	        	 String email="";
	        	 while(rs.next())
	        	 {
				 customer=rs.getString("name");
				 email=rs.getString("email");
				 
				 System.out.println("name:"+customer+" email:"+email);
	        	 }
	        	 String insert_query = "insert into booking values ('"+customer+"','"+email+"','"+specialist+"','"+datetime+"')";
				    
	        	 stmt.executeUpdate(insert_query);
	        	 
	        	 out.println("<meta http-equiv=\"refresh\" content=\"0 url = ThankYou.jsp\">");
	         
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
