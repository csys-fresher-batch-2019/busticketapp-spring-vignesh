<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
<center><h2>BusTicketApp</h2></center>
<img src="assets/images/busimage.jpg"
width="1000" height="300"
alt="busimage"/>
<h3>UserRegistration</h3>
<form action="RegisterServlet">
Enter Name: <input type="text" name="name"
placeholder="Enter Name" required autofocus/>
<br/><br/>
Enter Email: <input type="email" name="email" placeholder="Enter Email"
required>
<br/><br/>
Enter password:
<input type="password" name="password" placeholder="Enter Password" required >
<br/><br/>
Enter Date of Birth: <input type="date" name="dob" placeholder="Enter DOB"
min ="1950-01-01" max="2020-05-03"/>
<br/><br/>
Gender:
<input type="radio" name="gender" value="M" required> male
<input type="radio"name="gender" value="F">female
<br/><br/>
Enter MobileNumber:<input type="text" name="contactNumber"
 pattern="[0-9]{10}" title="10 digit mobile no" placeholder="ContactNumber" required>
<br><br>
<%-- Enter UserId:<input type="number" name="userid" min="100"
placeholder="Enter UserID" required />
<br/><br/> --%>

<button type="submit" >submit</button>
<button type="reset" >reset</button>
<br/>
<video width="320" height="240" controls>
<source src="assets/videos/busvideo.mp4" type="video/mp4"> 
</video>
</form>
</body>
</html>