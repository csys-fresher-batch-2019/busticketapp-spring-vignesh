<%@page import="com.chainsys.busticketapp.model.BusTiming"%>
<%@page import="com.chainsys.busticketapp.model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>passengerInformation</title>
</head>
<br>
<body style="background-color:Tomato;">
<center><img src="assets/images/busimage.jpg"
width="200" height="100"
alt="busimage"/></center>
<center>USER ID:${User.userId}</center>
<br/>
<center><table border="1">
<thead><tr><th>Bus</th> <th>Timing </th> </tr></thead>
<tbody>
<tr><td>${Timing.getBusNo()}</td> <td>${Timing.getDepartureTime()}</td></tr>
</tbody>
</table></center>
<br/>
<%
String busno=request.getParameter("busNo");
request.setAttribute("bus", busno);
%>
<%-- <%
		String infoMessage = (String) request.getAttribute("infoMessage");
		String errorMessage = (String) request.getAttribute("errorMessage");
		if (infoMessage != null)
			out.println(infoMessage);
		if (errorMessage != null)
			out.println(errorMessage);
	%> --%>
	
<jsp:include page="message.jsp"></jsp:include>
	
<center><h3>Enter Passenger Details..</h3></center>
<form action="passengerservlet">
<h3><center>Enter Passenger Name:<input type="text" name="passengerName"
 placeholder="passengername"  required/></center></h3>
<h3><center>Enter Age:<input type="number" name="Age" placeholder="age"  required/></center></h3>
<h3><center>Enter Gender:
<input type="radio" name="Gender" value="Male" required> male
<input type="radio"name="Gender" value="Female">female<br/></center>
<h4><center>Enter MobileNumber:<input type="text" name="mobileNumber"
 pattern="[0-9]{10}" title="10 digit mobile no" placeholder="mobileno" required></center></h4><br>
<center><button type="SUBMIT">SUBMIT</button></center>
</form>
</body>
</html>