
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		boolean newbie=true;
		
		//fetch cookies info using request object
		Cookie[] cookies=request.getCookies();
		
		if(cookies==null)
		{
			System.out.println("Newbie");
			newbie=true;
		}
		else
		{
			for(int i=0;i<cookies.length;i++)
			{
				if(cookies[i].getName().equals("repeatedVisitor") && (cookies[i].getValue().equals("yes")))
				{
					newbie=false;
					break;
				}
			}
			System.out.println("Not a newbie");
		
		}
		
		if(newbie==true)
		{
			Cookie visitorCookie=new Cookie("repeatedVisitor","yes");
			visitorCookie.setMaxAge(60*60*24*7);
			response.addCookie(visitorCookie);
			
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html; charset=UTF-8");
	      
	      PrintWriter out = response.getWriter();
	 
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
				}
			 	    
				 String nemail = request.getParameter("email");
				 String npass=request.getParameter("pass");
				 String nauth_id=request.getParameter("auth_id");
				 
				 if(nemail.equals(email) && npass.equals(pass) && nauth_id.equals(auth_id))
				 {
					 out.println("<meta http-equiv=\"refresh\" content=\"0 url = ChooseSpecialist.jsp\">");
					 
				 }
				 else
				 {
					 out.println("<h2>Error in Login Try Again!!<h2>");
					 out.println("<a href='Login.jsp'>Login</a>");
					 
				 }
				 
				 
				 ResultSet st=stmt.executeQuery("select name from registration_info where email='"+nemail+"'");
				 String get_name="";
				 while(st.next())
				 {
					 get_name=st.getString("name");
				 }
				 
				 String insert_query = "insert into login values ('"+get_name+"','"+nemail+"')";
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
