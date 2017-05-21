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
    
    int flno = Integer.parseInt(request.getParameter("flno"));
    String name = request.getParameter("name");
    String date = request.getParameter("date");
    int phno = Integer.parseInt(request.getParameter("phno"));
 	Random r = new Random();
 	int seatno = r.nextInt(200);

	boolean flag = false;	
	Statement stmt = con.createStatement();
	String query = "SELECT flno FROM flight";
	ResultSet rs = stmt.executeQuery(query);
 	while ( rs.next()){
		if ( rs.getInt("flno") == flno)
 			flag = true;
 	}
 
 	if ( flag ){
 		String query2 = "INSERT INTO seat (flno, dtime, name, phone, sno) VALUES (?, ?, ?, ? ,?)";
 		PreparedStatement p = con.prepareStatement(query2);
 		p.setInt(1, flno);
 		p.setString(2, date);
 		p.setString(3, name);
 		p.setInt(4, phno);
 		p.setInt(5, seatno);
 		p.executeUpdate(); 		
 	}
 	
    %>
       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Seat Booking</title>
</head>
<body>
	<h1>Online Reservation</h1>
	
	<%if (flag) { %>
		<p>
		Flight Number: <%=flno %> <br>
		Seat Number: <%=seatno %> <br>
		Date: <%=date %> <br>
		Name: <%=name %> <br>
		Phno: <%=phno %> <br>
		</p>
	
	<% } else {%>
		<p> Invalid Flight Number</p>
	<% } %>
</body>
</html>