package trng.java.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerAddServlet
 */
public class ManagerAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String studentId = request.getParameter("studentid");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		System.out.println("role :" + role);
		System.out.println("studentid " + studentId);
		try {
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
				//printResponse(request, response);
				response.sendRedirect("Admin.jsp");
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	private void printResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head> </head>");
//		out.println("<body>");
//		out.println("<h1> Student : "+ request.getParameter("username")
//				+ " Added successfully </h1>");
//		out.println("<br>");
//			out.println("<h1><a href='imp/Admin.jsp'>Admin Homepage</a></h1>");
//		out.println("</body>");
//		out.println("</html>");
//		out.close();
	}
}