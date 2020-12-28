<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>
		Choose your Specialist
	</title>
</head>
<body>
	<style type="text/css">
		h1{
			text-align: center;
			font-style: oblique;
			font-size: 75px;
		}
		button
		{
			text-align: right;
			font-size: 60px;
		}
		input{
 		    font-size: 60px; 
 		    font-family: times new roman;
 		    display: inline;
 		    margin-left:110px;
 		    margin-right:40px;
		}
		a{
			float:right;
		}
	</style>
	<a href="RegistrationEditor.jsp">edit profile</a><br>
	<a href = "BookingEditor.jsp">edit booking</a>
	<h1>Choose Your Specialist : </h1>
	<input type=button onClick="parent.location='Child.jsp'" value='Child' name="Child">
	<input type=button onClick="parent.location='Eye.jsp'" value='Eye' name="eye">
	<input type=button onClick="parent.location='Dentist.jsp'" value='Dentist' name="Dentist">
	<input type=button onClick="parent.location='Skin.jsp'" value='Skin' name="Skin">
	
	
</body>
</html>