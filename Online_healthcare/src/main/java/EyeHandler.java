

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
 * Servlet implementation class EyeHandler
 */
public class EyeHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EyeHandler() {
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
		
	      PrintWriter out = response.getWriter();
	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html><head>");
	         out.println("<meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Echo Servlet</title></head>");
	         out.println("<body><h2>APPOINTEMENT SUMMARY</h2>");
	         
	         Class.forName("com.mysql.cj.jdbc.Driver");
	         
	         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_healthcare","root","Ujjw@l.16");
	         
	         Statement stmt = con.createStatement();
	         
	         out.println("<h2>Hostipal : Paras Hospital</h2>");
	         out.println("<h3>Doctor's Name : Dr. Lubna</h3>");
	         // Name
	         String specialist="Dr.Lubna";
	         
	         String date = request.getParameter("Date");
	        
	        	 out.println("<p><h3>Date: " +date + "</h3></p>");
	         
	         String time=request.getParameter("selectbox");
	     
	        	 out.println("<p><h3>Time: " + time + "</h3></p>");
	        	 
	        	 String datetime=date+time;
	     
	        	 ResultSet rs=stmt.executeQuery("select name,email from login order by name desc limit 1");
				 String name=rs.getString("name");
				 String email=rs.getString("email");
				 
	        	 String insert_query = "insert into booking values ('"+name+"','"+email+"','"+specialist+"','"+datetime+"')";
				    
	        	 stmt.executeUpdate(insert_query);
	         
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
