
<%@ page import="java.io.*,javax.servlet.ServletException,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,java.util.Arrays,java.util.List,java.util.Set,java.util.Date,java.util.Collections"%>
<%@ taglib prefix="c"  uri="coretag"%>
<aside class="sidebar">
	
            <ul>
<%--                	<% String role=(String)(session.getAttribute("role")); %> --%>
<%--                	<%= out.println(role) %> --%>
<%--                	<c:set var="role" scope="session" value="${sessionScope.role}"/> --%>
               	
              
               	<c:if test="${sessionScope.role eq 'admin' }" >
               	 <li><a href="body.jsp?action=add">Add Student</a></li>
                 <li class=""><a href="body.jsp?action=update">Update Student</a></li>
                  <li class=""><a href="body.jsp?action=delete">Delete Student</a></li>
                   <li class=""><a href="body.jsp?action='display">Display Students</a></li>
               	</c:if>
               	<c:if test="${sessionScope.role eq 'clerk' }">
                  <li class=""><a href="body.jsp?action='update'">Update Student</a></li>
                  <li class=""><a href="body.jsp?action='display'">Display Students</a></li>  
               	</c:if>
          
               	
<%--                	<% if(role.equalsIgnoreCase("admin"))	{ %> --%>

<%--             <%} else if(role.equalsIgnoreCase("clerk")) { %>     --%>

<%--                   <%} else {%> --%>
<%--                     <center><h4>IMCS Group</h4></center> --%>
<!--                          <li class=""><a href="index.jsp">Home</a></li> -->
<!--            				 <li class=""><a href="#">Careers</a></li> -->
<!--            				 <li class=""><a href="#">Sitemap</a></li> -->
<!--           				 <li class=""><a href="#">Global Services</a></li> -->
<!--            				 <li class=""><a href="#">Contact</a></li> -->
<!--           				  <li class=""><a href="login.jsp">Login</a> -->
<%--                     <%  }   %> --%>
<!--                     </ul> -->

    </aside>	  