<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%
   	 	String user = (String)session.getAttribute("user");
    	if(user == null)
    		response.sendRedirect("index.jsp");
    	
    	String name = request.getParameter("name");
    	String gender = request.getParameter("gender");
    	String company = request.getParameter("company");
    	double salary = Double.parseDouble(request.getParameter("income"));
    	double tax = 0.0;
    	double percent = 0.0;
    	
    	if(salary > 100000 && salary <= 500000 )
    		percent = 0.15;
    	else if (salary > 500000)
    		percent = 0.20;
    	tax = (salary*percent);
    	
    	session.setAttribute("name", name);
    	session.setAttribute("company", company);
    	session.setAttribute("gender", gender);
    	session.setAttribute("salary", salary);
    	session.setAttribute("tax", tax);
    	session.setAttribute("percent", percent);
    	
    	response.sendRedirect("dataCapture.jsp");
    	
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>