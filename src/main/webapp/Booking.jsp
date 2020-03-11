<%@page import="com.chainsys.busticketapp.model.UserRegistration"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import = "java.time.LocalDate" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking</title>
</head>
<body>
<body style="background-color:pink;">
<center><img src="assets/images/busimage.jpg"
width="200" height="100"
alt="busimage"/></center>
<form action="BookingServlet">
<center>USER ID:${User.userId}</center>
<br/>
<h3><center>Enter Booking Details..</center></h3>
<h3><center>Enter Bus No:<input type="number" name="bus_no" value="${BusNo}"readonly/></center></h3>

<h3><center>Enter PassengerId:<input type="number" name="passengerid"
 pattern="[0-9]{4}" title="passenger id" placeholder="PassengerId" min="1000" required></center></h3>

<h3><center>Enter NoOf Ticket:<input type="number" name="noOfTicket" placeholder="NoOfTicket" min="1"required/></center></h3>

 <h3><center><label for="journeydate">Journey Date:</label>
  <input type="date" id="journeydate" name="journeydate" value = "${journeydate}" readonly></center></h3><br/>

<center><button type="SUBMIT">BOOK</button></center>
</form>
</body>
</html>