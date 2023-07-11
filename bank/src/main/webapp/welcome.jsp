<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome page</title>
</head>
<body>
	<% 
	session=request.getSession();
	String name=(String)session.getAttribute("name");
	String accountno=(String)session.getAttribute("accountno");
	out.println("<h3>Welcome "+name+"</br>");
	out.println("Account Number : "+accountno);
	out.println("</h3>");
	%>
	</br>
	<a href="">View Balance</a></br></br>
	<a href="">Apply Loan</a></br></br>
	<a href="">Send Money</a></br></br>
	<a href="">Change Name</a></br></br>
	<a href="">Change Password</a></br></br>
	<a href="">Logout</a></br></br>
	
</body>
</html>