<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="DiseaseModel" scope="session" class="java.lang.String" />
<jsp:useBean id="Print" scope="session" class="java.lang.String" />
<jsp:useBean id="Home" scope="session" class="java.lang.String" />
<jsp:useBean id="selectedDisease" scope="session"
	class="java.lang.String" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<style type="text/css">
  body {background-color: #3410C6}  
</style>

<title>Thank You</title>

</head>
<body>
	<img class="print" align="right" style="padding-right:39px;" src="./images/logo.png"
		width="400" height="67" /> 
		<font size="6" class="div" color="cornsilk" style="padding-left:40px;">Thank You for Submitting</font>
		<a href="/irb_approval_request/LogoutServlet" style="float: top;padding-left: 1400px;"><font
		size="2" class="div" color="cornsilk">Logout</font></a>
	<FORM ACTION="SuccessServlet" METHOD="POST">
	</FORM>



</body>
</html>