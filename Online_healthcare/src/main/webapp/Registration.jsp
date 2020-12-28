<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head><title>HealthCare System | Login</title>

<link rel="stylesheet" href="/mystyle.css" type="text/css" />
</head>
<body background="healthcare.jpg">
<form method="post" action="/Online_healthcare/RegistrationHandler" name="form2">
<table width="900" align=center>
	<tr>
	<td colspan="2"><%@ include file="/style_header.jsp" %></td>
    </tr>
	<tr >
	<td colspan="2">
	<table border ="0"  align="center" >
	<tr><td>Name</td>
	<td align="center" ><input type ="text" name="name" id="name" value="" /></td></tr>
	<tr><td>E-mail</td>
	<td align="center" ><input type ="text" name="email" id="email" value="" /></td></tr>
	<tr><td>Password</td>
	<td align="center" ><input type ="password" name="pass" id="pass" value="" /></td></tr>
	<tr><td>Gender</td>
	<td align="center" ><input type="radio" name="gender" value="m" checked />Male
    <input type="radio" name="gender" value="f" />Female</td></tr>
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
		<td colspan="2"><%@include file="/style_footer.jsp"%></td>
	</tr>
	</table>
</form></body></html> 