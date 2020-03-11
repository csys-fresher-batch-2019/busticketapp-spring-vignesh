<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<title>NoOfBusespage</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<body style="background-color:yellow;">
	<h3>List Buses</h3>
	<table border="1">
	<a href="searchbus.jsp">Back
		<thead>
			<tr>
				<th>S.No</th>
				<th>Bus No</th>
				<th>Bus Name</th>
				<th>Class</th>
				<th>Amount</th>
				<th>Total Seats</th>
				<th>Available Seats</th>
				<th>Timing</th>
				<th>Book</th>
			</tr>
		</thead>
		<tbody>


			<%
				int i = 1;
				//for (ListOfBuses in : list) {
					
			%>
			<c:forEach items="${busList}" var="b">
			

			<tr>
			<td><%=i++%></td>
				<td>${b.busNo}</td>
				<td>${b.busName}</td>
				<td>${b.clazz}</td>
				<td>${b.amount}</td>
				<td>${b.seatAvailability.availableSeats}</td>
				<td>${b.seatAvailability.totalSeats}</td>
				<td>${b.busTiming.departureTime}</td>
				<td><a href="BusTimingServlet?busNo=${b.getBusNo()}&Timing=${b.getBusTiming().getDepartureTime()}">click</a></td>
				</tr>
					</c:forEach>
			<%
			//}
				%>

</tbody>
</table>	
</body>
<jsp:include page="Logout.jsp"/>
</html>
