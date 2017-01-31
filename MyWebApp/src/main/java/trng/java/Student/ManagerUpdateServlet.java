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

/**
 * Servlet implementation class ManagerUpdateServlet
 */
public class ManagerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerUpdateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("modify");
		System.out.println("option " + option);
		String role=(String) request.getSession().getAttribute("role");
		System.out.println("role "+role);
		String id = request.getParameter("studentID");
		try {
			PreparedStatement pst;
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "password");
			if (option.equalsIgnoreCase("deletestudent")) {
				String sql = "delete from studentLogin where studentid=?";
				pst = con.prepareStatement(sql);
				pst.setString(1, id);
				pst.executeUpdate();
				response.sendRedirect("/MyWebApp/allStudQuery.jsp");
			} else if (option.equalsIgnoreCase("UpdateInfo") && role.equalsIgnoreCase("admin")) {
				String sql = "update studentLogin SET username=?,password=? where studentid=?";
				pst = con.prepareStatement(sql);
				pst.setString(1, request.getParameter("username"));
				pst.setString(2, request.getParameter("password"));
				pst.setString(3, id);
				pst.executeUpdate();
				response.sendRedirect("/MyWebApp/allStudQuery.jsp");
			}
			else if(option.equalsIgnoreCase("UpdateInfo") && role.equalsIgnoreCase("clerk"))
			{
				String sql = "update studentLogin SET username=?,password=? where studentid=?";
				pst = con.prepareStatement(sql);
				pst.setString(1, request.getParameter("username"));
				pst.setString(2, request.getParameter("password"));
				pst.setString(3, id);
				pst.executeUpdate();
				response.sendRedirect("/MyWebApp/cViewUpdate.jsp");
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
	//	response.sendRedirect("/MyWebApp/imp/mUpdate.jsp");
	}
}
