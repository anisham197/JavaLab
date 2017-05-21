<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    <%@page import="java.sql.*" %>
    <%@page import="java.util.*" %>
    
    <%
    String DRIVER = "com.mysql.jdbc.Driver";
    String HOST = "jdbc:mysql://localhost:3306/java";
    String USER = "root";
    String PASS = "root";
    Connection con = null;
    
    Class.forName(DRIVER);
    con = DriverManager.getConnection(HOST, USER, PASS);
    
   String day = request.getParameter("day");   
   Statement stmt = con.createStatement();
   String query = "SELECT * FROM flight WHERE day='" + day + "'";
   ResultSet rs = stmt.executeQuery(query);
  
    %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Daily Flights</title>
</head>
<body>
	<table border="1">
	 <thead>
	 	<th>Flight Number</th>
	 	<th>Flight Name</th>
	 	<th> Day</th>
	 </thead>
	 
	 <tbody>
	  <% while (rs.next()) { %>
	  	<tr>
	  		<td><%=rs.getInt("flno") %></td>
	  		<td><%=rs.getString("flname") %> </td>
	  		<td><%=rs.getString("day") %> </td>
	  	</tr>
	  
	  <% } %>
	 
	 </tbody>
	</table>
</body>
</html>