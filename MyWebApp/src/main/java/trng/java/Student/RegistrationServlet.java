package trng.java.Student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String studentId = request.getParameter("studentid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		System.out.println("role :"+role);
		System.out.println("studentid "+studentId);
		try {
			if (role.equalsIgnoreCase("student")) {

				String sql = "INSERT INTO studentLogin (studentId, username, password) VALUES (?,?,?)";
				PreparedStatement pst;

				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "root");
				pst = con.prepareStatement(sql);
				pst.setString(1, studentId);
				pst.setString(2, username);
				pst.setString(3, password);
				int rs = pst.executeUpdate();
				if (rs != 0) {
					response.sendRedirect("MyWebApp/login.jsp");
					//printResponse(request, response);
				}
			} else {
				if (role.equalsIgnoreCase("admin")) {
					System.out.println(role);
					String sql = "INSERT INTO adminLogin (username, password) VALUES (?,?)";
					PreparedStatement pst;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "root");
					pst = con.prepareStatement(sql);
					pst.setString(1, username);
					pst.setString(2, password);
					int rs = pst.executeUpdate();
					if (rs != 0) {
						response.sendRedirect("/MyWebApp/login.jsp");
						//printResponse(request, response);
					}
				} else if (role.equalsIgnoreCase("clerk")) {
					String sql = "INSERT INTO clerkLogin (username, password) VALUES (?,?)";
					PreparedStatement pst;
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "root");
					pst = con.prepareStatement(sql);
					pst.setString(1, username);
					pst.setString(2, password);
					int rs = pst.executeUpdate();
					if (rs != 0) {
						response.sendRedirect("/MyWebApp/login.jsp");
						//printResponse(request, response);
					}
				}
				
			}

		} catch (MySQLIntegrityConstraintViolationException  e) {
				
				response.sendRedirect("/MyWebApp/create_account.jsp");
		
		}
		catch(SQLException | ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}
	private void printResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {

//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head> </head>");
//		out.println("<body>");
//		out.println("<h1>" + request.getParameter("role") + " : " + request.getParameter("username")
//				+ " Registration successfull </h1>");
//		out.println("<br>");
//		if (request.getParameter("role").equalsIgnoreCase("student"))
//			out.println("<h1><a href='imp/login.jsp'>Click here to Login</a></h1>");
//		out.println("</body>");
//		out.println("</html>");
//		out.close();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}