<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="userName" scope="session" class="java.lang.String" />
<jsp:useBean id="investigator" scope="session" class="java.lang.String" />
<jsp:useBean id="projTitle" scope="session" class="java.lang.String" />
<jsp:useBean id="institution" scope="session" class="java.lang.String" />
<jsp:useBean id="noStudyDetails" scope="session"
	class="java.lang.String" />

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Consent Page</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
	background-color: #3410C6
}
</style>
</head>
<body>
	<img class="print" align="right" style="padding-right:39px;" src="./images/logo.png"
		width="400" height="67" />
	<h1>
		<font size="6" class="div" color="cornsilk" style="padding-left:40px;">IRB Study Consent</font>

	</h1>
	<script type="text/javascript">
		function EnableSubmit() {
			document.consent.submitConsent.disabled = true;
			if (document.consent.checkbox.checked == true) {
				document.consent.submitConsent.disabled = false;
			}
			if (document.consent.checkbox.checked == false) {
				document.consent.submitConsent.enabled = false;
			}
		}
	</script>
	<a href="/irb_approval_request/LogoutServlet" style="float: top;padding-left: 1400px;" ><font
		size="2" class="div" color="cornsilk">Logout</font></a>
	<form name="consent" method="post" action="RegServlet">

		<table style="height: 600px; background-color: #10B7C6;"
			align="center" width="95%" cellpadding="0" cellspacing="0">

			<tr height="100px">
				<td align="left" style="padding-left: 300px; padding-right:300px; padding-top: 200px" valign="middle"><b>By agreeing with this statement you
						give consent to use the entered data for the study: Clinical Trial
						recruitment using a distributed cell phone applications based
						approach. Here the applications will communicate with our Clinical
						Trials Management System and communicate this information to
						prospective participants and clinicians. We are studying whether
						or not this method speeds the rate of recruitment to clinical
						trials. Thank you for considering participating in our trial.</b></td>
			</tr>
			<tr height="80px">
				<td align="center">I Agree&nbsp;<input type="checkbox"
					name="checkbox" value="Accept" onClick="EnableSubmit()"></td>
			</tr>
			<tr>
				<td align="center" style="padding-left: 60px" valign="top"><input
					name="submitConsent" type="submit" value="Submit Consent"
					style="width: 20%; font-size: 1.0em;"
					class="btn btn-large btn btn-success btn-lg btn-block" disabled /></td>
			</tr>
		</table>
		<%
		session.removeAttribute("investigator");
		session.removeAttribute("projTitle");
		session.removeAttribute("institution");
		session.removeAttribute("noStudyDetails");
		%>
	</form>
</body>
</html>
