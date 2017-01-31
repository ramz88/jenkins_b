<%@ page import="java.io.*,javax.servlet.ServletException,javax.servlet.annotation.WebServlet,javax.servlet.http.HttpServlet,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse,java.util.Arrays,java.util.List,java.util.Set,java.util.Date,java.util.Collections"%>

<nav>
        <ul>
            <li class=""><a href="index.jsp">Home</a></li>
            <li class=""><a href="#">Careers</a></li>
            <li class=""><a href="#">Sitemap</a></li>
            <li class=""><a href="#">Global Services</a></li>
            <li class=""><a href="#">Contact</a></li>
             <%String user=(String)(session.getAttribute("sUserName")); %>
              <% String role=(String)(session.getAttribute("role")); %>
            <li class="end"><a href=""><%=user%>'s Account</a>
            <ul>
            <% if(role.equalsIgnoreCase("admin")){%>
                 <li class=""><a href="Admin.jsp">Admin Home</a></li>
                 <li class=""><a href="logout.jsp">Logout</a></li>
                 </ul>
            <% }else if(role.equalsIgnoreCase("clerk")){ %>
              <li class=""><a href="clerk.jsp">Clerk Home</a></li>
                 <li class=""><a href="logout.jsp">Logout</a></li>
                 </ul>
            <% } else { %>
            <li class=""><a href="student.jsp">Student Home </a></li>
            <li class=""><a href="logout.jsp">Logout</a></li>
            </ul>
            <% } %>
        </ul>
</nav>