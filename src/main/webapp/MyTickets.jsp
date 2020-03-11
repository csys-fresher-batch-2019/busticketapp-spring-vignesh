<%@page import="com.chainsys.busticketapp.model.Booking"%>
<%@page import="com.chainsys.busticketapp.dao.impl.BookingDAOImplementation"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>MY Tickets</h2>
<%
ArrayList<Booking> listMyTickets= ( ArrayList<Booking> ) request.getAttribute("MyTickets");
if ( listMyTickets != null){
%>
<table border="1">
		<thead>
			<tr>
				<th>S.No</th>
				<th>Ticket No</th>
				<th>Bus No</th>
				<th>Passenger Id</th>
				<th>No Of Ticket</th>
				<th>Journey Date</th>
				<th>Total Amount</th>
				<th>Status</th>
			</tr>
		</thead>
		<tbody>
		<a href="homeuser.jsp">Back
	<%
	int i=1;
		for (Booking in : listMyTickets) {
					
	%>			
	     		<tr>
	     		<td><%=i++%></td>
				<td><%=in.getTicketNo()%></td>
				<td><%=in.getBusNo()%></td>
				<td><%=in.getPassengerId()%></td>
				<td><%=in.getNoOfTicket()%></td>
				<td><%=in.getJourneyDate()%></td>
				<td><%=in.getTotalAmount()%></td>
				<td><%=in.getStatus()%></td>
				</tr>
				
			<% } %>
			
<%} %>

</body>
</html>