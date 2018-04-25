<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="duplicate" scope="session" class="java.lang.String" />
<jsp:useBean id="registrationErr" scope="session"
	class="java.lang.String" />
<jsp:useBean id="fname" scope="session" class="java.lang.String" />
<jsp:useBean id="lname" scope="session" class="java.lang.String" />
<jsp:useBean id="registeruser" scope="session" class="java.lang.String" />
<jsp:useBean id="registerpwd" scope="session" class="java.lang.String" />

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">

<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
<style type="text/css">
body {
	background-color: #3410C6
}
</style>
<title>Registration Page</title>
</head>

<body>
<img class="print" align="right" style="padding-right:39px;" src="./images/logo.png"
		width="400" height="67" />
			<h1>
		<font size="6" class="div" color="cornsilk" style="padding-left:40px;">IRB Survey
			Registration</font>

	</h1>
	<script type="text/javascript">
		function checkPassword(str) {
			// at least one number, one lowercase and one uppercase letter and one special character
			// at least four characters that are letters, numbers or the underscore
			var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=[^!@#\$%]*[!@#\$%]).{8,}/;
			return re.test(str);
		}

		function checkFormForPwd() {

			if (document.register.txtPassword.value == "") {
				alert("Error: Password cannot be blank!");
				document.register.txtPassword.focus();
				return false;
			} else if (!checkPassword(document.register.txtPassword.value)) {
				alert("The password you have entered is not valid!");
				document.register.txtPassword.value = '';
				document.register.txtPassword.focus();
				return false;
			}
			return true;
		}
		function checkFormForUserName() {
			re = /[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.(?:[A-Za-z]{2}|com|org|net|edu|gov|mil|biz|info|mobi|name|aero|asia|jobs|museum)/;
			if (document.register.txtUserName.value == "") {
				alert("Error: Username cannot be blank!");
				document.register.txtUserName.focus();
				return false;
			} else if (!re.test(document.register.txtUserName.value)) {
				alert("Error: Username must contain only letters, numbers and underscores followed by domain name!");
				document.register.txtUserName.value = '';
				document.register.txtUserName.focus();
				return false;
			}

			return true;
		}
	</script>
	<a href="/irb_approval_request/LogoutServlet" style="float: top;padding-left: 1400px;"><font
		size="2" class="div" color="cornsilk">Logout</font></a>
	<form name="register" method="post" action="RegServlet">
		<table style="height: 600px; background-color: #10B7C6;"
			align="center" width="95%" cellpadding="0" cellspacing="0">
			<%
				String duplicateLogin = (String) session
				.getAttribute("duplicate");
			String registrationError = (String) session
					.getAttribute("registrationErr");
			String firstname = (String) session
					.getAttribute("fname");
			String lastname = (String) session
					.getAttribute("lname");
			String registereduser = (String) session
					.getAttribute("registeruser");
			String registeredpwd = (String) session
					.getAttribute("registerpwd");
		%>
			<tr>
				<td align="left" style="padding-left: 600px"
					valign="bottom"><b><font color="black"
						style="font-family: fantasy;">UserName</font></b></td>
				<td align="left" style="padding-right: 600px" valign="bottom">
					<%if (registereduser != null && !registereduser.isEmpty()) {%> <input
					type="text" name="txtUserName" value="<%=registereduser%>"
					onchange="return checkFormForUserName();" /> <%}else{ %> <input
					type="text" name="txtUserName"
					onchange="return checkFormForUserName();" /> <%} %>
				</td>
			</tr>
			<tr style="height: 50px">
				<td align="left" style="padding-left: 600px"
					valign="center"><b><font color="black"
						style="font-family: fantasy;">Password</font></b></td>
				<td align="left" style="padding-right: 600px" valign="center">
					<%if (registeredpwd != null && !registeredpwd.isEmpty()) {%> <input
					type="password" name="txtPassword" value="<%=registeredpwd%>"
					onchange="return checkFormForPwd();" /> <%}else{ %> <input
					type="password" name="txtPassword"
					onchange="return checkFormForPwd();" /> <%} %>
				</td>
			</tr>
			<tr  style="height: 40px">
				<td align="left" style="padding-left: 600px"
					valign="top"><b><font color="black"
						style="font-family: fantasy;">First name</font></b></td>
				<td align="left" style="padding-right: 600px" valign="top">
					<%if (firstname != null && !firstname.isEmpty()) {%> <input
					type="text" name="fname" value="<%=firstname%>" /> <%}else{ %> <input
					type="text" name="fname" /> <%} %>
				</td>
			</tr>
			<tr style="height: 50px">
				<td align="left" style="padding-left: 600px"
					valign="top"><b><font color="black"
						style="font-family: fantasy;">Last name</font></b></td>
				<td align="left" style="padding-right: 600px" valign="top">
					<%if (lastname != null && !lastname.isEmpty()) {%> <input type="text"
					name="lname" value="<%=lastname%>" /> <%}else{ %> <input type="text"
					name="lname" /> <%} %>
				</td>
			</tr>
			<tr>
				<td align="right" style="padding-left: 160px" valign="top"></td>
				<td align="left" style="padding-right: 160px" valign="top"><input
					name="registerUser" type="submit" value="Register"
					style="width: 20%; font-size: 1.0em;"
					class="btn btn-large btn btn-success btn-lg btn-block" /></td>
			</tr>
		</table>
		<%
		if(duplicateLogin!=null && duplicateLogin.equals("duplicate")){%>
		<div style="color: red">Already Registered!!</div>
		<%	
		}
		if(registrationError!=null && registrationError.equals("registrationErr")){%>
		<div style="color: red">Please enter all the fields!!</div>
		<%	
		}
		session.removeAttribute("duplicate");
		session.removeAttribute("registrationErr");
		session.removeAttribute("fname");
		session.removeAttribute("lname");
		session.removeAttribute("registeruser");
		session.removeAttribute("registerpwd");
		%>
	</form>
</body>
</html>
