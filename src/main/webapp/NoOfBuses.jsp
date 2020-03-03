<%@page import="java.time.LocalDate"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="com.chainsys.busticketapp.dao.BusTicketDAO"%>
<%@page import="com.chainsys.busticketapp.model.ListOfBuses"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.chainsys.busticketapp.dao.impl.BusTicketManagerImplimentation"%>
<!DOCTYPE html>
<html>
<title>NoOfBusespage</title>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<body style="background-color:yellow;">
	<h3>List Buses</h3>
	<%
		String BusSource = request.getParameter("source");
		String BusDestination = request.getParameter("destination");
		String journeydate = request.getParameter("journeydate");
		BusTicketDAO dao = new BusTicketManagerImplimentation();
		//LocalDate journeyDate = LocalDate.parse(journeydate);
		List<ListOfBuses> list = dao.sourceStationlist(BusSource, BusDestination);
	%>
	  <c:set var="busList" value="<%=list%>"></c:set>
	 <%
 HttpSession sessiondate=request.getSession();
 sessiondate.setAttribute("journeydate", journeydate);
 %>
	<table border="1">
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
<jsp:include page="Logout.jsp"/></center>
</html>
