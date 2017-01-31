<!doctype html>
<!-- Activision -->
<html>
<head>
<style type="text/css">
  .login {
  vertical-align: right;
  background: #eceeee;
  border: 1px solid #42464b;
  border-radius: 6px;
  height: 257px;
  margin: 20px auto 0;
  width: 298px;
}
.login h1 {
  background-image: linear-gradient(top, #f1f3f3, #d4dae0);
  border-bottom: 1px solid #a6abaf;
  border-radius: 6px 6px 0 0;
  box-sizing: border-box;
  color: #727678;
  display: block;
  height: 43px;
  font: 600 14px/1 'Open Sans', sans-serif;
  padding-top: 14px;
  margin: 0;
  text-align: center;
  text-shadow: 0 -1px 0 rgba(0,0,0,0.2), 0 1px 0 #fff;
}
input[type="password"], input[type="text"] {
  background: url('http://i.minus.com/ibhqW9Buanohx2.png') center left no-repeat, linear-gradient(top, #d6d7d7, #dee0e0);
  border: 1px solid #a1a3a3;
  border-radius: 4px;
  box-shadow: 0 1px #fff;
  box-sizing: border-box;
  color: #696969;
  height: 39px;
  margin: 31px 0 0 29px;
  padding-left: 37px;
  transition: box-shadow 0.3s;
  width: 240px;
}
input[type="password"]:focus, input[type="text"]:focus {
  box-shadow: 0 0 4px 1px rgba(55, 166, 155, 0.3);
  outline: 0;
}
.forgot:hover { color: #3b3b3b }
input[type="submit"] {
  width:240px;
  height:35px;
  display:block;
  font-family:Arial, "Helvetica", sans-serif;
  font-size:16px;
  font-weight:bold;
  color:#fff;
  text-decoration:none;
  text-transform:uppercase;
  text-align:center;
  text-shadow:1px 1px 0px #000;
  padding-top:6px;
  margin: 29px 0 0 29px;
  position:right;
  cursor:pointer;
  border: none;  
  background-color: #000;
  background-image: linear-gradient(top,#3db0a6,#3111);
  border-top-left-radius: 5px;
  border-top-right-radius: 5px;
  border-bottom-right-radius: 50px;
  border-bottom-left-radius:50px;
  vertical-align: right;
}
</style>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>IMCS Group</title>
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
</div>
<!-- Body -->
<center><h1><span>Login Page</h1></center>
<div align="center">
	<form method="post" action="/MyWebApp/slogin">
    	 <input type="text" placeholder=" Username" name="username" required>
     	 <br>
  		 <input type="password" placeholder="Password" name="password" required><br>
  		 <br>
  		 Admin<input type="radio" checked="checked" name="role"  value="admin" > 
  		 Clerk <input type="radio" name="role"  value="clerk" >  
  		 Student <input type="radio" name="role" value="student" ><br>
         <input type="submit" value="Login">
</form>
<center><p><a href="create_account.jsp">New User? Sign up here</a></p></center>
</div>
<%@ include file="footer.jsp" %>
</div>
</body>
</html>