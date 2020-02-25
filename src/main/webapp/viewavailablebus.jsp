<%@page import="com.chainsys.busticketapp.model.UserRegistration"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.busticketapp.dao.SeatAvailabilityDAO"%>
<%@page
	import="com.chainsys.busticketapp.dao.impl.SeatAvailabilityimplementation"%>
<%@page import="com.chainsys.busticketapp.model.SeatAvailability"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View AvailableSeats</title>
</head>
<body style="background-color: Tomato;">
	<center>
		<img src="assets/images/busimage2.jpg" width="300" height="200"
			alt="busimage" />
	</center>
	<%
		UserRegistration user = (UserRegistration) session.getAttribute("User");
	%>
	<center>
		USER ID:<%=user.getUserId()%></center>
	<br>
	<center>
		<h1>Available Seats:</h1>
	</center>
	<form action="Passengerinfo.jsp">
		<%
			String busNo = request.getParameter("BusNo");
			int BusNo = Integer.parseInt(busNo);
			String Timing = request.getParameter("Timing");
			//out.println(Timing);
			Integer availableTickets = (Integer) request.getAttribute("AVAILABLE_SEATS");
		%>
		<center>
			<h1><%=availableTickets%></h1>
		</center>

		<center>
			<button>
				<a href="Passengerinfo.jsp?BusNo=<%=BusNo%>">NewPassenger 
			</button>
		</center>
		<br />
		<center>
			<button><a href="Booking.jsp?BusNo=<%=BusNo%>">Already Register </button>
		</center>
	</form>
</body>
<center><jsp:include page="Logout.jsp"/></center>
</html>

