<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<title>indexpage</title>
<style>
.button {
	background-color: brown;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	margin: 4px 2px;
	cursor: pointer;
}
.header {
  background-color: blue;
  color: #FFFFFF;
  padding: 15px;
}
.grid-container {
  display: grid;
  grid-template-columns: auto auto auto auto ;
  grid-gap: 20px;
  padding: 30px;
}
</style>
<body>
<div class="header">
<center><h2>BusTicketApp</h2></center>
</div>

<h2>Features:</h2>
<div class="grid-container"></div>
<ul>
<div><a href="UserRegistration.jsp" class="button">Register  </a></div><br/>
<div><a href=adminlogin.jsp class="button">AdminLogin</a></div><br/>
<div><a href=userlogin.jsp class="button">UserLogin</a></div>
</ul>
</body>
</html>
