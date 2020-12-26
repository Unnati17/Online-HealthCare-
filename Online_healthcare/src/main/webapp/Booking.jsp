<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>HealthCare System | Login</title>

<link rel="stylesheet" href="/mystyle.css" type="text/css" />
</head>
<body background="healthcare.jpg">
<form method="post" action="/Online_healthcare/RegistrationHandler" name="form2">
<h2>BOOK AN APPIONTMENT</h2>
<h3>SPECILAISTS</h3>
<table width="900" align=center>
	<tr>
	<td colspan="2"><%@ include file="/people_header.jsp" %></td>
    </tr>
	<tr >
	<td colspan="2">
	<table border ="0"  align="center" >
	<tr><td>SPECIALISTS</td></tr>
	<td align="center" ><input type="radio" name="specialist" value="eye" checked />Eye specialist</td></tr>
    <td align="center" ><input type="radio" name="specialist" value="child" checked />Child specialist</td></tr>
    <td align="center" ><input type="radio" name="specialist" value="dental" checked />dentist</td></tr>
    <td align="center" ><input type="radio" name="specialist" value="child" checked />Child specialist</td></tr>
    <td align="center" ><input type="radio" name="specialist" value="child" checked />Child specialist</td></tr>
    
    <tr><td>Age</td>
	<td align="center" ><input type ="text" name="age" id="age" value="" /></td></tr>
	<tr><td colspan="2" align="center" ><input type ="submit" name="submit" id="submit" value="Submit" />
	<input type="hidden" name="action_submit" id="action_submit" value="user_registration_submit"/>
	<%
	String msg=(String)session.getAttribute("lErrorMsg");
	if (msg!=null && msg.length()>0 ){
	%>
    <tr>
	<td colspan="2" align="center"> 
	<%	out.println("<div class=boldred>"+msg+"</div>"); %>
	</td>
	</tr>
	<%	}	%>
	</table>
	</td></tr>
	<tr>
		<td colspan="2"><%@include file="/people_footer.jsp"%></td>
	</tr>
	</table>
</form></body></html> 