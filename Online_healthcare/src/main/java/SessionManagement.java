

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionManagement
 */
public class SessionManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html;charset=UTF-8");
	      
	      PrintWriter out = response.getWriter();

	      HttpSession session = request.getSession();
	      Integer accessCount;

	      accessCount = (Integer)session.getAttribute("visits");
	         if (accessCount == null) 
	         {
	            accessCount = 1;  
	         } else {
	        	 accessCount = accessCount.intValue()+1;
//	        	 accessCount = new Integer(accessCount + 1);
	         }

	         session.setAttribute("visits", accessCount);

	      try {
	         out.println("<!DOCTYPE html>");
	         out.println("<html>");
	         out.println("<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
	         out.println("<title>Session Test Servlet</title></head><body>");
	         out.println("<h2>You have access this site " + accessCount + " times in this session.</h2>");
	         out.println("<p>(Session ID is " + session.getId() + ")</p>");

	         out.println("<p>(Session creation time is " +
	               new Date(session.getCreationTime()) + ")</p>");
	         out.println("<p>(Session last access time is " +
	               new Date(session.getLastAccessedTime()) + ")</p>");
	         out.println("<p>(Session max inactive interval  is " +
	               session.getMaxInactiveInterval() + " seconds)</p>");

	         out.println("<p><a  href='" + request.getRequestURI() +  "'>Refresh</a>");
	         out.println("<p><a  href='" + response.encodeURL(request.getRequestURI())  +
	                     "'>Refresh with  URL rewriting</a>");
	         out.println("</body></html>");
	        
//	         session.invalidate();
	      } finally {
	         out.close(); 
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
