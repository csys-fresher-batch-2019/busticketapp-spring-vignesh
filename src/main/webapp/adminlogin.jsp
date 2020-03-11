<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
<center><h2>BusTicketApp</h2></center><br/>
<style>
body{
background-color:#CCCCC;
background-image:url("assets/images/busimage.jpg");
background-repeat:no-repeat;
background-size: 100% 100%;
}
</style>
<center><h3>AdminLogin</h3></center>
<form action="Adminloginservlet" method="post"><br/><br/><br><br><br>
<b>Enter AdminName:</b> <input type="text" name="name"
placeholder="Enter AdminName" required autofocus/>
<br/><br/>
<b>Enter password:</b>
<input type="password" name="password"style="margin-left:20px;" 
placeholder="Enter Password"required >
<br/><br>
<button type="submit"style="margin-left:150px;">submit</button>

<%
String result = (String) request.getParameter("res");
if (result != null) {
out.println("<center><font color=red>" + result + "</font></center>");
}
%>

<%-- <%
String errorMessage=request.getParameter("errorMessage");
if(errorMessage!=null)
{
out.println("<font color='red'>"+errorMessage+"</font>");
}
%> --%>
<jsp:include page="message.jsp"></jsp:include>
</form>
</body>
</html>