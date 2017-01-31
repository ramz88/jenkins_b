<%
			String action=(String)request.getParameter("action");
			if(action!=null)
			{
			if(action.equals("add"))
			{	%>
				  <%@include file="mAdd.jsp" %> 
				
			<%}
			else if(action.equalsIgnoreCase("update"))
			{%>
				  <%@include file="allStudQuery.jsp" %> 
			<%} }else{%>
				<br>
				<center><h1>Admin HomePage </h1></center>
			<%} 
			%>
			