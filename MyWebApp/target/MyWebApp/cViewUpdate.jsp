<%@ page import="java.io.*,javax.servlet.ServletException,javax.servlet.*,java.sql.*,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,java.util.Arrays,java.util.List,java.util.Set,java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Clerk View Update</title>
  <link rel="stylesheet" href="styles.css" type="text/css" />
</head>
<body>
<div id="container">
    <header>
    	<h1><a href="index.jsp">IMCS<span> Group</span></a></h1>
        <h2><a>Talent <span> Teamwork  Technology</span> </a></h2>
    </header>
<%
if(session.getAttribute("sUserName")==null)
 {%> <%@include file="header.jsp"%> 
 <%} 
else
  {%>  <%@include file="header_login.jsp"%> 
  <%}
%>
<div id="body">
<section id="content">
<center><h2>Clerk Page</h2></center><br>
<center><h3>View All Students</h3></center><br>
<form method = "get" action = "/MyWebApp/cUpdate.jsp">
<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "root");
Statement st = con.createStatement();
ResultSet rs=st.executeQuery("select * from studentLogin");
int id=0;
String uName=null;
String pwd=null;
%>
<table border=1>
<tr>
<th>
</th>
<th>Student id</th>
<th>Student Username </th>
<th>Student Password </th>
</tr>
<%
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
<center><input type="submit" value="Update Student " /></center>
</form>
</section>
        
 <%@ include file="navbar.jsp" %>

   <div class="clear"></div>
   </div>
<!-- Footer -->
    <footer>
    <%@ include file="footer.jsp" %>
    </footer>
    </div>
    </div>

    </body>
    </html>
