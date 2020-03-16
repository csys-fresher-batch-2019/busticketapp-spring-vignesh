<%@page import="com.chainsys.busticketapp.model.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>
.header {
  background-color: purple;
  color: #FFFFFF;
  padding: 15px;
}
</style>
<body>
<center>USER ID:${User.userId}</center>
<body style="background-color:pink;">
	<div class="header">
	<center><h2>BusTicketApp</h2></center>
	</div>
	<h3>User Features:</h3>
	<ul>
		<li><a href="searchbus.jsp">FindBus</a></li>
		<br/>
		<li><a href="index.jsp">Home</a></li>
		<br/>
		<li><a href="MyTicketServlet">MyTickets</a>
	</ul>
</body>
<jsp:include page="Logout.jsp"/></center>
</html>
