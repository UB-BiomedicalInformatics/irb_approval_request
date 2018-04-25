<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%@ page import="javax.servlet.http.HttpSession"%>


<!DOCTYPE xhtml PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="studyID" type="java.lang.Integer" scope="session" />
<jsp:useBean id="investigator" type="java.lang.String" scope="session" />
<jsp:useBean id="projTitle" type="java.lang.String" scope="session" />
<jsp:useBean id="institution" type="java.lang.String" scope="session" />

<html>
<head>
<link href=”bootstrap/css/bootstrap.min.css” rel=”stylesheet”
	type=”text/css” />
<link rel="stylesheet" href="bootstrap/css/bootstrap.css"
	type="text/css">
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IRB Exempt Review Approval</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
body {
	background-color: #3410C6
}
.table {
	width: 95%;
	height: 600px;
}
</style>
</head>
<body>
	<img class="print" align="right" style="padding-right:39px;" src="./images/logo.png"
		width="400" height="67" />
	<h1>
		<font size="6" class="div" color="cornsilk" style="padding-left:40px;">Exemption</font>
	</h1>
	<a href="/irb_approval_request/LogoutServlet" style="float: top;padding-left: 1400px;"><font
		size="2" class="div" color="cornsilk">Logout</font></a>
	<FORM ACTION="IRB_ExemptServlet" METHOD="POST">
		<table class="table table-bordered"
			style="height: 600px; background-color: #10B7C6;" align="center"
			width="95%" cellpadding="0" cellspacing="0">
			<tbody>
			<tr>
				<td colspan="10"><b><font size="4">1. GENERAL
							EXCLUSIONS FROM EXEMPTIONS(Check if "Yes". If either is checked,
							the research is not exempt.):</font><br></b></td>
			</tr>
			<tr>
				<td>1a. The research is FDA-regulated.</td>
				<td width="100px"><input type="radio" name="attr1" value="Yes1">Yes</label>
					<input type="radio" name="attr1" value="No2">No</label></td>
				<br>
			</tr>
			<tr>
				<td>1b. The research involves <font color="blue"><u>Prisoners</u></font>
					and is conducted or funded by DHHS, Dept. of Defense (DOD), or. <br>
				</td>
				<td><input type="radio" name="attr2" value="Yes3">Yes <input
					type="radio" name="attr2" value="No4">No</td>
			</tr>
			<tr>
				<td>1c. The research involves interactions with <font
					color="blue"><u>Prisoners</u></font>. <br>
				</td>
				<td><input type="radio" name="attr3" value="Yes5">Yes <input
					type="radio" name="attr3" value="No6">No</td>
			</tr>
			<tr>
				<td colspan="10"><b>2. The research falls into one or more
						of the following categories(One or more categories must be
						checked):<br>
				</b></td>
			</tr>
			<tr>
				<td>2.1. Research conducted in established or commonly accepted
					educational settings, involving normal educational practices as
					long as it is observed with no interactions. (Both the procedures
					involve normal education practices and the objectives of the
					research involve normal educational practices.) <br>
				</td>
				<td><input type="radio" name="attr4" value="Yes7">Yes <input
					type="radio" name="attr4" value="No8">No</td>
			</tr>
			<tr>
				<td>2.2. Research involving the collection or study of existing
					data, documents, records, pathological specimens, or diagnostic
					specimens if the information is recorded by the investigator in
					such a manner that subjects cannot be identified, directly or
					through identifiers linked to the subjects. <b>(For research
						conducted, funded, or otherwise subject to regulation by any
						federal agency "existing" means "existing at the time the research
						is proposed." Otherwise, it means "existing at the time the
						research is proposed or will exist in the future for non-research
						purposes.")</b> <br>
				</td>
				<td><input type="radio" name="attr5" value="Yes9">Yes <input
					type="radio" name="attr5" value="No10">No</td>
			</tr>
			<tr>
				<td colspan="10"><b>3. Criteria for approval of exempt
						research(Check if <b>"Yes"</b>).<br>
				</b></td>
			</tr>
			<tr>
				<td>3a. The research involves no more than <font color="blue"><u>Minimal
							Risk</u></font> to subjects.<b>(Must be checked.)</b> <br>
				</td>
				<td><input type="radio" name="attr6" value="Yes11">Yes
					<input type="radio" name="attr6" value="No12">No</td>
			</tr>
			<tr>
				<td>3b. Selection of subjects is equitable. (That is, the
					research is appropriate for the population being studied. Research
					is for a department review.)<b>(Must be checked.)</b> <br>
				</td>
				<td><input type="radio" name="attr7" value="Yes13">Yes
					<input type="radio" name="attr7" value="No14">No</td>
			</tr>
			<tr>
				<td>3c. If there is accessing or retaining of identifiable
					information: <b>(If checked the following must be checked.)</b> <br>
				</td>
				<td><input type="radio" name="attr8" value="Yes15">Yes
					<input type="radio" name="attr8" value="No16">No</td>
			</tr>
			<tr>
				<td>3d. There are adequate provisions to maintain the
					confidentiality of the data. <br>
				</td>
				<td><input type="radio" name="attr9" value="Yes17">Yes
					<input type="radio" name="attr9" value="No18">No</td>
			</tr>
			<tr>
				<td>3f. There are no interactions with subjects<br>
				</td>
				<td><input type="radio" name="attr10" value="Yes19">Yes
					<input type="radio" name="attr10" value="No20">No</td>
			</tr>

			<tr>
				<td colspan="2" align="center" style="padding-left: 60px"
					valign="top"><input name="submitExempt" type="submit"
					value="Submit" style="width: 20%; font-size: 1.0em;"
					class="btn btn-large btn btn-success btn-lg btn-block" /></td>
			</tr>
			</tbody>
		</table>
	</FORM>
</body>
</html>