<%@page import="com.chainsys.busticketapp.model.UserRegistration"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MyTickets</title>
</head>
<body>
<form action="MyTicketServlet" method="post"><br/>
<body style="background-color:cyan;">
<%UserRegistration user=(UserRegistration)session.getAttribute("User");
%>
<center>UserId:<%=user.getUserId() %></center>
<br/>
<h2><center>MY TICKETS</center></h3>
<br/><br/>
<b>Enter UserId:</b> <input type="number" name="userid"
placeholder="Enter UserId" required autofocus/><br/><br/>
<button type="submit"style="margin-left:96px;">submit</button>
</form>
</body>
</html>