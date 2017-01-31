package trng.java.Student;
import java.io.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentLoginServlet extends HttpServlet {
   
   private static final long serialVersionUID = 1L;
   
   public void init() throws ServletException{
	  
   }
   
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   HttpSession session = request.getSession();	
	   String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		try {
			String sql=null;
			if (role.equalsIgnoreCase("student")) 
				sql = "select * from studentLogin where username = ? and password = ?";
			else if (role.equalsIgnoreCase("admin")) 
				sql = "select * from adminLogin where username = ? and password = ?";
			else if (role.equalsIgnoreCase("clerk")) 
				sql = "select * from clerkLogin where username = ? and password = ?";
			System.out.println(sql);
			System.out.println("Role"+role);
				PreparedStatement pst;
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "root");
				pst = con.prepareStatement(sql);
				pst.setString(1, username);
				pst.setString(2, password);

				ResultSet rs = pst.executeQuery();
				if (rs.next()) {
					session.setAttribute("sUserName", username);
					session.setAttribute("role", role);
					printResponse(request, response);
				}
				else{
					response.sendRedirect("/MyWebApp/login.jsp");
//					PrintWriter out = response.getWriter();   
//		            out.println("<html>");
//		            out.println("<head>");
//		            out.println("<title>Login Servlet Result</title>");  
//		            out.println("</head>");
//		            out.println("<body>");
//		            out.println("Invalid Login Please re-enter");
//		            out.println("<br>");
//		            out.println("<a href='imp/login.jsp'>Click here to Re-Login</a>");
//		            out.println("</body>");
//		            out.println("</html>");
//		            out.close();  
				}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		} 
         
   }
   private void printResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
	   	String url=null;
	   		if(request.getParameter("role").equalsIgnoreCase("admin"))
	   			url="/MyWebApp/Admin.jsp";
	   		else if(request.getParameter("role").equalsIgnoreCase("clerk"))
	   			url="/MyWebApp/clerk.jsp";
	   		else
	   			url="/MyWebApp/student.jsp";
	   	
	   		response.sendRedirect(url);
//	        PrintWriter out = response.getWriter();
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Login Servlet Result</title>");  
//            out.println("</head>");
//            out.println("<body>");
//            out.println("Welcome");
//            out.println(request.getParameter("username")); 
//            out.println("Login Successful ");
//            out.println("<br><a href='"+url+"'>Homepage</a>");  
//            out.println("</body>");
//            out.println("</html>");
//            out.close(); 	   		   	
}

public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request,response);
}
  
 }
