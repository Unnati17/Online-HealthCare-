<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Child Specialist</title>
</head>
<body>
<form method="post" action="/Online_healthcare/ChildHandler" name="form2">
	<style>
		h1
		{
			text-align: center;
			font-variant-caps: small-caps;
		}
		h3{
			font-family: courier new;
			text-align: center;
		}
		input
		{
			margin-left: auto;
			margin-right: auto;
			display: block;
		}
	</style>
	<h1>Select date and time of the appointment</h1><br><br>
	<h3>Hostipal : Medanta Hospital</h2>
	<h3>Doctor's Name : Dr. Ranjit</h2>
	<h3>Date : <input type="Date" name="Date"></h2>
	<h3>Time : <select name = "selectbox" id = "selectbox">
  				<option value="08:00:00">8:00</option>
  				<option value="09:00:00">9:00</option>
  				<option value="09:30:00">9:30</option>
  				<option value="20:00:00">20:00</option>
  				<option value="21:00:00">21:00</option>

  </select></h3>
  <input type="Submit" id="btnDelete" value="Submit" />
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
  <script type="text/javascript">
  	$(function(){
  	$("#btnDelete").bind("click",function()
  	{
  		$("#selectbox option:selected").remove();
  	});
  });
  </script>

</table>
</body>
</html>