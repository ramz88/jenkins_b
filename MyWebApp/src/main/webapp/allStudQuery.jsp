<%@page import="org.omg.PortableInterceptor.ForwardRequest"%>
<%@ page import="java.io.*,javax.servlet.ServletException,javax.servlet.*,java.sql.*,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,java.util.Arrays,java.util.List,java.util.Set,java.util.Date"%> 
<%
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "password");
				Statement st = con.createStatement();
				ResultSet rs=st.executeQuery("select * from studentLogin");
				request.setAttribute("result",rs);
				request.getRequestDispatcher("mUpdate.jsp").forward(request,response);
%>
