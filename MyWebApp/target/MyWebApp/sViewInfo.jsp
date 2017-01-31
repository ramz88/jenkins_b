<%@ page import="java.io.*,javax.servlet.ServletException,javax.servlet.*,java.sql.*,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,java.util.Arrays,java.util.List,java.util.Set,java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Student View Info</title>
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
<center><h2>Student Page</h2></center><br>
<center><h3>View Student Profile</h3></center><br>
<%
String username=(String)session.getAttribute("sUserName");
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/imcs", "root", "password");
PreparedStatement pst;
String sql="select * from studentLogin where username = ?";
pst = con.prepareStatement(sql);
pst.setString(1, username);
ResultSet rs=pst.executeQuery();
int id=0;
String uName=null;
String pwd=null;
%>
<table border=1>
<tr>
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
<td > <%= id %></td>
<td > <%=uName%></td>
<td ><%=pwd%></td>
</tr>

<% }%>
</table>
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
