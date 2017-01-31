<%@ page import="java.io.*,javax.servlet.ServletException,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,java.util.Arrays,java.util.List,java.util.Set,java.util.Date,java.io.IOException,java.io.PrintWriter,javax.servlet.RequestDispatcher,javax.servlet.ServletException,javax.servlet.http.HttpServlet,javax.servlet.http.*"%>

<%
 HttpSession newsession = request.getSession(false);
%>
<%
 if (newsession != null)
 {%>
  <% newsession.invalidate();
 }
 %>
 <%
 response.sendRedirect("login.jsp");
 %>