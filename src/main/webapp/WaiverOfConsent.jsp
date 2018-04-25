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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Waiver of Written Documentation of Consent</title>
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
		<font size="6" class="div" color="cornsilk" style="padding-left:40px;">Waiver of Written
			Documentation of Consent</font>
	</h1>
	<script type="text/javascript">
		function DisablePageOptions() {
			document.getElementById("id3").disabled = true;
			document.getElementById("id4").disabled = true;
			document.getElementById("id5").disabled = true;
			document.getElementById("id6").disabled = true;
			document.getElementById("id7").disabled = true;
			document.getElementById("id8").disabled = true;
			document.getElementById("id9").disabled = true;
			document.getElementById("id10").disabled = true;
			var y = document.getElementById('id1').checked;
			if (y == true) {
				document.getElementById("id3").disabled = false;
				document.getElementById("id4").disabled = false;
				document.getElementById("id5").disabled = false;
				document.getElementById("id6").disabled = false;
				document.getElementById("id7").disabled = false;
				document.getElementById("id8").disabled = false;
				document.getElementById("id9").disabled = false;
				document.getElementById("id10").disabled = false;
			}
		}
	</script>
	<a href="/irb_approval_request/LogoutServlet" style="float: top;padding-left: 1400px;"><font
		size="2" class="div" color="cornsilk">Logout</font></a>
	<form name="waiverConsent" method="post" action="WaiverConsentServlet">
		<table class="table table-bordered"
			style="height: 600px; background-color: #10B7C6;" align="center"
			width="95%" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td colspan="10">The purpose of this checklist is to provide
						support for IRB members or the <font color="blue"><u>Designated
								Reviewer</u></font> following the WORKSHEET: Criteria for Approval
						(HRP-314) when research involves the waiver of written
						documentation of consent. This checklist must be used for all
						reviews (initial, continuing, modification, review by the convened
						IRB, and review using the expedited procedure.) <br> . For
						initial review using the expedited procedure and modifications and
						continuing reviews where the determinations relevant to this
						checklist made on the previous review have changed, the <font
						color="blue"><u>Designated Reviewer</u></font> completes this
						checklist to document determinations required by the regulations
						along with protocol specific findings justifying those
						determinations. The <font color="blue"><u>Designated
								Reviewer</u></font> attaches this checklist to "Submit Non-Committee
						Review" activity. The IRB Office (HRPP/HSPO) retains this
						checklist in the protocol file. <br> . For initial review
						using the convened IRP and for modifications and continuing
						reviews where the determinations relevant to this checklist made
						on the previous review have changed, one of the following two
						options may be used: <br> 1. The convened IRB completes the
						corresponding section of the meeting minutes to document
						determinations required by the regulations along with protocol
						specific findings justifying those determinations, in which case
						this checklist does not need to be completed or retained. <br>
						2. The convened IRB completes this checklist to document
						determinations required by the regulations along with protocol
						specific findings justifying those determinations and the IRB
						Office (HRPP/HSPO) uploads this checklist in the "Submit Committee
						Review" activity and retains this checklist in the protocol file.
					</td>
				</tr>
				<tr>
					<td colspan="10"><b><font size="4">The research
								must meet one of the following two sets of criteria</font><br></b></td>
				</tr>
				<tr>
					<td><font size="4"><b>1. Waiver of Written
								Documentation of Consent</b> (Check if <b>"Yes"</b>. All must be
							checked)</font><br></td>
					<td><input type="radio" id="id1" name="var1" value="Yes1"
						onClick="DisablePageOptions()"><b>Yes</b><input
						type="radio" id="id2" name="var1" value="No2"
						onClick="DisablePageOptions()"><b>No</b></td>
				</tr>
				<tr>
					<td colspan="10"><b>Investigator:</b>&nbsp;<%=session.getAttribute("investigator")%></td>
				</tr>
				<tr>
					<td colspan="10"><b>Project Title:</b>&nbsp;<%=session.getAttribute("projTitle")%></td>
				</tr>
				<tr>
					<td colspan="10"><b>Institution:</b>&nbsp;<%=session.getAttribute("institution")%></td>
				</tr>
				<tr>
					<td>1a. The research presents no more than <font color="blue"><u>Minimal
								Risk</u></font> of harm to subjects.<br>
					</td>
					<td><input type="radio" id="id3" name="var2" value="Yes3"
						disabled>Yes <input type="radio" id="id4" name="var2"
						value="No4" disabled>No</td>
				</tr>
				<tr>
					<td>1b. The research involves no procedures for which written
						consent is normally required outside of the research context.<br>
					</td>
					<td><input type="radio" id="id5" name="var3" value="Yes5"
						disabled>Yes <input type="radio" id="id6" name="var3"
						value="No6" disabled>No</td>
				</tr>
				<tr>
					<td>1c. Written information describing the research <b>does
							not need to be provided</b> to the subject or the subject's legally
						authorized representative.
					</td>
					<td><input type="radio" id="id7" name="var4" value="Yes7"
						disabled>Yes <input type="radio" id="id8" name="var4"
						value="No8" disabled>No<br></td>
				</tr>
				<tr>
					<td>1d. The research is not FDA-regulated.<br>
					</td>
					<td><input type="radio" id="id9" name="var5" value="Yes9"
						disabled>Yes <input type="radio" id="id10" name="var5"
						value="No10" disabled>No</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-left: 60px"
						valign="top"><input name="submitWaiverOfConsent"
						type="submit" value="Submit Consent Waiver"
						style="width: 20%; font-size: 1.0em;"
						class="btn btn-large btn btn-success btn-lg btn-block" /></td>
				</tr>
			</tbody>
		</table>
	</FORM>
</body>
</html>