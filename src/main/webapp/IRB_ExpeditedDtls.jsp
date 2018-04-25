<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.*"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%@ page import="javax.servlet.http.HttpSession"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="studyID" type="java.lang.Integer" scope="session" />
<jsp:useBean id="investigator" type="java.lang.String" scope="session" />
<jsp:useBean id="projTitle" type="java.lang.String" scope="session" />
<jsp:useBean id="institution" type="java.lang.String" scope="session" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IRB Expedited Review Approval</title>
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
		<font size="6" color="cornsilk" style="padding-left:40px;">Expedited Review</font>
	</h1>
	<a href="/irb_approval_request/LogoutServlet" style="float: top;padding-left: 1400px;"><font
		size="2" class="div" color="cornsilk">Logout</font></a>
	<FORM ACTION="IRB_ExpeditedServlet" METHOD="POST">
		<table class="table table-bordered"
			style="height: 600px; background-color: #10B7C6;" align="center"
			width="95%" cellpadding="0" cellspacing="0">
			<tbody>
			<tr>
				<td><b><font size="4">1. Is the study Retrospective?
							which means Is the collection or study of data, documents,
							records, pathological specimens, or diagnostic specimens existing
							at the time the research is proposed?</font></b></td>
				<td width="100px"><input type="radio" name="ele1" value="Yes1">Yes
					<input type="radio" name="ele1" value="No2">No<br></td>
			</tr>
			<tr>
				<td colspan="10"><b>2. Initial Review,Continuing Review,or
						Modifications</b>(Check if <b>"Yes"</b> or <b>"N/A"</b>. All must be
					checked) <br></td>
			</tr>
			<tr>
				<td>2a. Identification of the subjects or their responses(or
					the remaining procedures involving identification of subjects or
					their responses) will <b><font color="blue"><u>NOT</u></font></b>
					reasonably place them at risk of criminal or civil liability or be
					damaging to their financial
					standing,employability,insurability,reputation,or be
					stigmatizing,unless reasonable and appropriate protections will be
					implemented so that risks related to invasion of privacy and breach
					of confidentiality are no greater than <font color="blue"><u>Minimal
							Risk</u></font>.(<b>"N/A"</b> if the research falls into category (8)(b)) <br>
				</td>
				<td width="100px"><input type="radio" name="ele2" value="Yes3">Yes
					<input type="radio" name="ele2" value="No4">No</td>
			</tr>
			<tr>
				<td>2b. The research is <font color="blue"><u><b>NOT</b></u></font>
					classified <br>
				<td><input type="radio" name="ele3" value="Yes5">Yes <input
					type="radio" name="ele3" value="No6">No</td>
				</td>
			</tr>
			<tr>
				<td>2c. The research will not release identified data and
					precautions would be taken to keep it safe. <br>
				</td>
				<td><input type="radio" name="ele4" value="Yes7">Yes <input
					type="radio" name="ele4" value="No8">No</td>
			</tr>
			<tr>
				<td>2d. Only IRB approved investigators will have access to data. <br>
				</td>
				<td><input type="radio" name="ele5" value="Yes9">Yes <input
					type="radio" name="ele5" value="No10">No</td>
			</tr>
			<tr>
				<td>2e. Data is stored in a password protected and encrypted
					file. <br>
				</td>
				<td><input type="radio" name="ele6" value="Yes11">Yes <input
					type="radio" name="ele6" value="No12">No</td>
			</tr>
			<tr>
				<td>2f. All the physical files will be secured in a locked
					area. <br>
				</td>
				<td><input type="radio" name="ele7" value="Yes13">Yes <input
					type="radio" name="ele7" value="No14">No</td>
			</tr>
			<tr>
				<td>2g. Identified data is destroyed once they are no longer
					needed for the study or when IRB Approval ends. <br>
				</td>
				<td><input type="radio" name="ele8" value="Yes15">Yes <input
					type="radio" name="ele8" value="No16">No</td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="padding-left: 60px"
					valign="top"><input name="submitExpedited" type="submit"
					value="Submit" style="width: 20%; font-size: 1.0em;"
					class="btn btn-large btn btn-success btn-lg btn-block" /></td>
			</tr>
			</tbody>
			</table>
			</FORM>
</body>
</html>