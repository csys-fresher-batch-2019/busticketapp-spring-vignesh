<%@page import="com.chainsys.busticketapp.model.BusTiming"%>
<%@page import="com.chainsys.busticketapp.dao.impl.BusTimingIplementation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bustimingpage</title>
</head>
<body>
<center><h2>BusTiming</h2></center>
<body style="background-color:pink;">
<form action="BusTimingServlet">
<%
BusTiming b= (BusTiming) request.getAttribute("BUS_TIMING");
%>
<br/>
<table cellspacing ="2" cellpadding ="2">
<tr>
<th>Bus No</th>
<th>Amount</th>
<th>Departure Time</th>
<th>Arrival Time</th>
</tr>
<%


if(b != null){
	
	%>
	<tr>
	<td><%=b.getBusNo() %></td>
	<td><%=b.getAmount() %></td>
	<td><%=b.getDepartureTime()%></td>
	<td><%=b.getArrivalTime() %></td>
	</tr>
	
<% 	
}
%>
</table><br/>
<a  href="viewavailablebus.jsp?BusNo=<%=b.getBusNo()%>">Availableseat</a>
</form>
</body>
</html>