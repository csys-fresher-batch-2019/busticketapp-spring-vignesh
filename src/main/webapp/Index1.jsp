<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>


<title>BUS APP</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
* {
 box-sizing: border-box;
}

body {
 margin: 0;
}

/* Style the header */
.header {
 background-color: #f1f1f1;
 padding: 20px;
 text-align: center;
}

/* Style the top navigation bar */
.topnav {
 overflow: hidden;
 background-color: #333;
}

/* Style the topnav links */
.topnav a {
 float: left;
 display: block;
 color: #f2f2f2;
 text-align: center;
 padding: 14px 16px;
 text-decoration: none;
}

/* Change color on hover */
.topnav a:hover {
 background-color: #ddd;
 color: black;
}

/* Create three equal columns that floats next to each other */
.column {
 float: left;
 width: 33.33%;
 padding: 15px;
}

/* Clear floats after the columns */
.row:after {
 content: "";
 display: table;
 clear: both;
}

/* Responsive layout - makes the three columns stack on top of each other instead of next to each other */
@media screen and (max-width:600px) {
 .column {
   width: 100%;
 }
}


<style>
.button {
 background-color: Orange;
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
.right
{
float:right
}
</style>
<body style = "background-color:blue">
</head>
<body>

<div class="header">
<a href="Logout.jsp"   class="button right"><h5>Logout</span></h5></a>
 <h1>WELCOME TO BUS TICKET APP !!!</h1>
 
</div>

<div class="topnav">
<a href="Index1.jsp"   class="button">INDEX&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
<a href="seachbus.jsp"  class="button">FIND BUS&emsp;&emsp;&emsp;&ensp;&nbsp;</a>
<a href="Ticketlist.jsp"  class="button">MY TICKETS&emsp;&ensp;&ensp;</a>
 <a href="index.jsp" class="button">HOME&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
<%-- <a href="ViewStudents.jsp"   class="button">View Students&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
--%>


</body>
</html>