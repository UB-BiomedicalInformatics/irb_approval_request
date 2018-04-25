<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="logout" scope="session" class="java.lang.String" />
<jsp:useBean id="authFail" scope="session" class="java.lang.String" />
<jsp:useBean id="wronguser" scope="session" class="java.lang.String" />
<jsp:useBean id="wrongpassword" scope="session" class="java.lang.String" />
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
<title>Login Page</title>
</head>

<body>
	<img class="print" align="right" style="padding-right:39px;" src="./images/logo.png"
		width="400" height="67" />
	<h1>
		<font size="6" class="div" color="cornsilk" style="padding-left:40px;">IRB Survey Login</font>

	</h1>
	<script type="text/javascript">
		function checkPassword(str) {
			// at least one number, one lowercase and one uppercase letter and one special character
			// at least four characters that are letters, numbers or the underscore
			var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=[^!@#\$%]*[!@#\$%]).{8,}/;
			return re.test(str);
		}

		function checkFormForPwd() {

			if (document.login.txtPassword.value == "") {
				alert("Error: Password cannot be blank!");
				document.login.txtPassword.focus();
				return false;
			} else if (!checkPassword(document.login.txtPassword.value)) {
				alert("The password you have entered is not valid!");
				document.login.txtPassword.value = '';
				document.login.txtPassword.focus();
				return false;
			}
			return true;
		}
		function checkFormForUserName() {
			re = /[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.(?:[A-Za-z]{2}|com|org|net|edu|gov|mil|biz|info|mobi|name|aero|asia|jobs|museum)/;
			if (document.login.txtUserName.value == "") {
				alert("Error: Username cannot be blank!");
				document.login.txtUserName.focus();
				return false;
			} else if (!re.test(document.login.txtUserName.value)) {
				alert("Error: Username must contain only letters, numbers and underscores followed by domain name!");
				document.login.txtUserName.value = '';
				document.login.txtUserName.focus();
				return false;
			}

			return true;
		}
	</script>
	<a href="/irb_approval_request/LogoutServlet" style="float: top;padding-left: 1400px;"><font
		size="2" class="div" color="cornsilk">Logout</font></a>
	<form name="login" method="post" action="RegServlet">
		<input type="hidden" name="pagename" value="login" />
		<table style="height: 600px; background-color: #10B7C6;"
		align="center" width="95%" cellpadding="0" cellspacing="0">
			<tr>
				<td align="left" style="padding-left: 600px" valign="bottom"><b><font
						color="black" style="font-family: fantasy;">UserName</font></b></td>
				<td align="left" style="padding-right: 600px" valign="bottom">
					<%
				String wrongusr = (String) session.getAttribute("wronguser");
				String wrongpwd = (String) session.getAttribute("wrongpassword");
				if (wrongusr != null) {
				%> <input type="text" name="txtUserName" value="<%=wrongusr%>" /> <%}else{%>
					<input type="text" name="txtUserName"
					onchange="return checkFormForUserName();" /> <%}%>
				</td>
			</tr>
			<tr style="height: 50px">
				<td align="left" style="padding-left: 600px;"
					valign="center"><b><font color="black"
						style="font-family: fantasy;">Password</font></b></td>
				<td align="left" valign="center">
					<%
				if (wrongpwd != null) {
				%> <input type="password" name="txtPassword" value="<%=wrongpwd%>" />
					<%}else{%> <input type="password" name="txtPassword"
					onchange="return checkFormForPwd();" /> <%} %>
				</td>
			</tr>

			<tr>
				<td align="right" style="padding-left: 60px" valign="top"><input
					name="login" type="submit" value="Login"
					style="width: 20%; font-size: 1.0em;"
					class="btn btn-large btn btn-success btn-lg btn-block" /></td>
				<td align="left" style="padding-left: 60px" valign="top"><input
					name="register" type="submit" value="Register"
					style="width: 20%; font-size: 1.0em;"
					class="btn btn-large btn btn-success btn-lg btn-block" /></td>
			</tr>
		</table>
		<%
			String logoutPage = (String) session.getAttribute("logout");
			String authFailPage = (String) session.getAttribute("authFail");

			if (authFailPage != null && authFailPage.equals("authFail")) {
		%>
		<div style="color: red">Please enter the correct credentials</div>

		<%
			}
			session.removeAttribute("wronguser");
			session.removeAttribute("wrongpassword");
			session.removeAttribute("authFail");
			session.removeAttribute("fname");
			session.removeAttribute("lname");
			session.removeAttribute("registeruser");
			session.removeAttribute("registerpwd");
			
			if (logoutPage != null && logoutPage.equals("logout")) {
				session.invalidate();
		%>
		<div style="color: red">You have been successfully logged out</div>
		<%} %>

	</form>
</body>
</html>
