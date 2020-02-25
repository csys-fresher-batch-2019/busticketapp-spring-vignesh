<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
	<h2>BusTicketApp</h2>
	<img src="assets/images/busimage.jpg" width="300" height="100"
		alt="busimage" />
	<h3>UserLogin</h3>
	<form action="Userloginservlet" method="post">
		Enter UserEmail: 
		<input type="email" name="Email_id"placeholder="Enter UserEmail" required autofocus/><br/><br>
		Enter password:
		 <input type="password" name="password" required> <br/>
		<button type="submit">submit</button>
		
		<%
String result = (String) request.getParameter("res");
if (result != null) {
out.println("<center><font color=red>" + result + "</font></center>");
}
%>

<%
String errorMessage=request.getParameter("errorMessage");
if(errorMessage!=null)
{
out.println("<font color='red'>"+errorMessage+"</font>");
}
%>
<br />
</form>
</body>
</html>