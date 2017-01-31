<!doctype html>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>IMCS Group</title>
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
<!-- Body -->

	<img class="header-image" src="/MyWebApp/images/logo.png" width = "100%" height = "100%" alt="Index Page Image" />

    <div id="body">		

	<section id="content">

	    <article>
			
			<h3>Welcome to IMCS Group Here we Inspire Innovate and Implement</h3>
			
            <p>iMCS Group is an IT Consulting Company that helps companies to optimize the business value of their IT investments and enables them to achieve world-class business performance.</p>	
            
            <p>iMCS Group provides support in strategic and operational aspects of IT implementations to help businesses implement growth strategies and leverage technology to achieve competitive advantage.</p>
			
		</article>
	
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