<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="java.util.*" %>

	<% 
	HashMap<String, String> users = new HashMap<>();
	users.put("anisha", "1234");
	users.put("root", "root");
	String status = request.getParameter("status");
	String msg = "";
	%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(status != null) {
	
		if (status.equals("2"))
			session.invalidate();
		
		else {
			String user = request.getParameter("user");
			String pass = request.getParameter("pass");
			
			if (users.containsKey(user) && users.get(user).equals(pass)){
				session.setAttribute("user", user);
				response.sendRedirect("dataCapture.jsp");
			}
			else {
				msg = "Incorrect Username/Password";
			}
		}
	}
	%>
	<p><%=msg%></p><br>
	<%@ include file="login.html" %>
	
</body>
</html>