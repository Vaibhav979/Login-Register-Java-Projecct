<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<link rel="stylesheet" type="text/css" href="indexStyle.css">
</head>
<body>
<%
HttpSession session1 = request.getSession(false);

if(session1!=null && session1.getAttribute("username")!=null){
	String username = (String) session1.getAttribute("username");
%>
<div class="container">
<h1>Welcome, <%= username %>!</h1>
<a href="LogoutServlet">LOGOUT</a>
</div>
<%} else{
	response.sendRedirect("login.jsp");
}
%>
</body>
</html>