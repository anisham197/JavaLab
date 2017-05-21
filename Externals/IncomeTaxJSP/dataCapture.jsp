<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import="java.util.*" %>
    <% Date date = new Date(); 
    	String user = (String)session.getAttribute("user");
		if(user == null)
			response.sendRedirect("index.jsp");
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tax Details</title>
</head>
<body>
	<h2>Welcome: <%=session.getAttribute("user") %></h2>
	<h4>Date: <%=date.toString() %></h4>
	
	<form action="calculateTax.jsp" method="get">
		Name: <input type="text" name="name"><br>
		Company: <select name="company"> 
			<option value="Microsoft">Microsoft</option>
			<option value="Google">Google</option>
			<option value="Facebook">Facebook</option>
		</select> <br>
		Gender: Male <input type="radio" name="gender" value="Male">
				Female <input type="radio" name="gender" value="Female"> <br>
		Income: <input type="number" name="income"><br>
		<input type="submit" value="Calculate Tax">
	</form>
	
	<% if(session.getAttribute("name") != null) { 
			String name = (String)session.getAttribute("name");
			String gender = (String)session.getAttribute("gender");
			String company = (String)session.getAttribute("company");
			double salary = (Double)session.getAttribute("salary");
			double tax = (Double)session.getAttribute("tax");
			double percent = (Double)session.getAttribute("percent");
	%>
	
	 <div>
	 	Name : <%=name %> <br>
	 	Gender : <%=gender %><br>
 		Company: <%=company %><br>
		Salary: <%=salary %><br>
		Income Tax: <%=tax%><br>
		Percent: <%=percent %><br>
	 	</div>
	
	<% } %>
	
	<a href="index.jsp?status=2">Logout</a>
	
</body>
</html>