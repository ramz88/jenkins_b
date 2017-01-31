 <%@ page import="java.io.*,javax.servlet.ServletException,javax.servlet.*,java.sql.*,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,java.util.Arrays,java.util.List,java.util.Set,java.util.Date"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IMCS</title>
<link rel="stylesheet" href="styles.css" type="text/css" />
</head>
<div id="container">
	<header>
	<h1>
		<a href="index.jsp">IMCS<span> Group</span></a>
	</h1>
	<h2>
		<a>Talent <span> Teamwork Technology</span>
		</a>
	</h2>
	</header>
	<div>
		<!-- Header -->
			<% if(session.getAttribute("sUserName")==null){ %>
									   <%@include file="header.jsp" %> 
			<%}else{ %>
										<%@include file="header_login.jsp" %> 
 		  <%} %>
		<!-- Body -->
		<div id="body">
			<section id="content"> 
<center><h2>Admin Page</h2></center><br>
<center><h3>View All Students</h3></center><br>
<form method = "get" action = "/MyWebApp/mModify.jsp">
<table border=1>
<tr>
<th>
</th>
<th>Student id</th>
<th>Student Username </th>
<th>Student Password </th>
</tr>
<%
ResultSet rs=(ResultSet)request.getAttribute("result");
int id=0;
String uName=null;
String pwd=null;
while(rs.next())
{	id=Integer.parseInt(rs.getString(1));
	uName=rs.getString(2);
	pwd=rs.getString(3);
%>
<tr>
<td><input type="radio" name="studentID"   value="<%=id%>"/></td>
<td > <%= id %></td>
<td > <%=uName%></td>
<td ><%=pwd%></td>
</tr>
<% }%>
</table><br>
<center><input type="submit" value="Update/Delete Student" /></center>
</form>

</section>
			<!-- Navbar -->
									<%@ include file="navbar_login.jsp"%>
			<div class="clear"></div>
		</div>
		<!-- Footer -->
		<footer> 			<%@ include file="footer.jsp"%>
		</footer>

	</div>

	</body>
</html>

 