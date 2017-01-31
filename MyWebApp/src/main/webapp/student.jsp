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
    	<h1><a href="index.jsp">IMCS<span> Group</span></a></h1>
        <h2><a>Talent <span> Teamwork  Technology</span> </a></h2>
    </header>
<div>
<!-- Header -->
<%
if(session.getAttribute("sUserName")==null)
 {%> <%@include file="header.jsp"%> 
 <%} 
else
  {%>  <%@include file="header_login.jsp"%> 
  <%}
%>
<!-- Body -->
<div id="body">   
    <section id="content">
      <center><h1><span>Student Page</h1></center><br>
<ul>
	<li><a href="sViewInfo.jsp">View Profile</a></li>
 </ul>
    </section>

    <!-- Navbar -->
   <%@ include file="navbar.jsp" %>

   <div class="clear"></div>
   </div>
    
<!-- Footer -->
	<footer>
	<%@ include file="footer.jsp" %>
	</footer>
	
	</div>

	</body>
	</html>
