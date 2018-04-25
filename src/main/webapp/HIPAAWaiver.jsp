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
<title>HIPAA Waiver</title>
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
		<font size="6" class="div" color="cornsilk" style="padding-left:40px;">HIPAA Waiver</font>
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
			document.getElementById("id11").disabled = true;
			document.getElementById("id12").disabled = true;
			document.getElementById("id13").disabled = true;
			document.getElementById("id14").disabled = true;
			document.getElementById("id15").disabled = true;
			document.getElementById("id16").disabled = true;
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
				document.getElementById("id11").disabled = false;
				document.getElementById("id12").disabled = false;
				document.getElementById("id13").disabled = false;
				document.getElementById("id14").disabled = false;
				document.getElementById("id15").disabled = false;
				document.getElementById("id16").disabled = false;
			}
		}
	</script>
	<a href="/irb_approval_request/LogoutServlet" style="float: top;padding-left: 1400px;"><font
		size="2" class="div" color="cornsilk">Logout</font></a>
	<form name="waiverHIPAA" method="post" action="HIPAAWaiverServlet">
		<table class="table table-bordered"
			style="height: 600px; background-color: #10B7C6;" align="center"
			width="95%" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td colspan="10">UNIVERSITY AT BUFFALO HUMAN RESEARCH
						PROTECTIONS PROGRAM</td>
				</tr>
				<tr>
					<td><b>Request for Waiver of the Authorization for Use of
							Individually Identifiable Health Information</b></td>
					<td><input type="radio" id="id1" name="bool1" value="Yes1"
						onClick="DisablePageOptions()"><b>Yes</b><input
						type="radio" id="id2" name="bool1" value="No2"
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
					<td colspan="10" align="center"><b><font size="4">INSTRUCTIONS</font><br></b></td>
				</tr>
				<tr>
					<td colspan="10">In most situations Federal regulations
						require that an individual's signed HIPAA authorization be
						obtained before their Individually Identifiable Health Information
						can be acquired, used or disclosed for research purposes in
						situations where HIPAA applies. A waiver of this authorization
						requirement allows you to acquire, use or disclose health
						information without securing such an authorization.<br>
					<br> You may apply to the IRB for a waiver of the
						authorization requirement if several regulatory criteria can be
						fulfilled. One criterion is key: the research could not <font
						color="blue"><u>practicably</u></font> be conducted without the
						waiver. If it will be difficult or impossible for you to secure a
						signed authorization from your research subjects, you pass an
						initial test for qualifying for a waiver of the authorization
						requirement.<br>
					<br> Some instances where the request for a waiver of
						authorization may be appropriate include:<br> .&nbsp;research
						on existing health information, e.g., medical records research<br>
						.&nbsp;research where a waiver of informed consent is also being
						requested, e.g.,survey research via phone<br>
					<br> The criteria that must be satisfied for <b>full</b>
						waiver of authorization are:<br>
					<br> . The research could not practicably be conducted without
						the waiver or alteration of authorization, i.e., there is no other
						mechanism available that would permit you to obtain the
						information needed for study recruitment under HIPAA.<br> .
						The research could not practicably be conducted without access to
						and use of the health information sought in the waiver.<br> .
						A brief description of the health information for which use or
						access has been determined to be necessary. The waiver will permit
						the researcher to access <font color="blue"><u>only</u></font>
						this information.<br> . The use or disclosure of health
						information involves no more than a minimal risk to the privacy of
						individuals, based on, at least, the presence of the following
						elements;<br> - An adequate plan to protect the identifiers
						from improper use and disclosure;<br> - An adequate plan to
						destroy the identifiers at the earliest opportunity consistent
						with conduct of the research, unless there is a health or research
						justification for retaining the identifiers or such retention is
						otherwise required by law; and<br> - Adequate written
						assurances are provided that the protected health information will
						not be reused or disclosed to any other person or entity, except
						as required by law, for authorized oversight of the research
						study, or for other research for which the use or disclosure of
						protected health information would be permitted.<br>
					<br> A <b>partial waiver</b>, or <b>alteration</b>, of the
						HIPAA authorization may also may be granted by the IRB in cases
						where granting a full waiver of authorization is not warranted.
						These additional mechanisms allow the IRB to alter or eliminate
						one or more of the regulatory elements normally required in the
						HIPAA authorization. Consult with the IRB for more information on
						these options.<br>
					<br> You can address all of the above criteria for a <b>full</b>
						waiver by completing and signing the Waiver of Authorization form
						and submitting it to the IRB for review.<br>
					<br>
					</td>
				</tr>
				<tr>
					<td><b>1. Is it true that no one other than the IRB
							approved study team will see the identified data.</b></td>
					<td width="100px"><input type="radio" id="id3" name="bool2"
						value="Yes3" disabled><b>Yes</b></label> <input type="radio"
						id="id4" name="bool2" value="No4" disabled><b>No</b></label></td>
				</tr>
				<tr>
					<td><b>2. This research project cannot be carried out
							without use of individually identifiable health information (why
							is using de-identified data not practicable?).</b><br></td>
					<td><input type="radio" id="id5" name="bool3" value="Yes5"
						disabled><b>Yes</b><input type="radio" id="id6"
						name="bool3" value="No6" disabled><b>No</b></td>
				</tr>
				<tr>
					<td><b>3. Obtaining a signed authorization from the
							research subjects is not practicable.</b><br></td>
					<td><input type="radio" id="id7" name="bool4" value="Yes7"
						disabled><b>Yes</b><input type="radio" id="id8"
						name="bool4" value="No8" disabled><b>No</b></td>
				</tr>
				<tr>
					<td><b>4. All study data will be kept on an encrypted
							drive and only the study participants will have access to that
							computer and only the study participants will have the password
							to decrypt the drive.</b><br></td>
					<td><input type="radio" id="id9" name="bool5" value="Yes9"
						disabled><b>Yes</b><input type="radio" id="id10"
						name="bool5" value="No10" disabled><b>No</b></td>
				</tr>
				<tr>
					<td><b>5. Individually identifiable health information
							will not be re-used or disclosed for other purposes.</b><br></td>
					<td><input type="radio" id="id11" name="bool6" value="Yes11"
						disabled><b>Yes</b><input type="radio" id="id12"
						name="bool6" value="No12" disabled><b>No</b></td>
				</tr>
				<tr>
					<td><b>6. You will destroy the personal identifiers at the
							earliest opportunity or when the IRB approval ends whichever
							comes sooner.</b><br></td>
					<td><input type="radio" id="id13" name="bool7" value="Yes13"
						disabled><b>Yes</b><input type="radio" id="id14"
						name="bool7" value="No14" disabled><b>No</b></td>
				</tr>
				<tr>
					<td><b>Principal Investigator: 7.</b> I attest that the use or
						disclosure of individually identifiable health information will
						involve no more than a minimal risk to the privacy of the research
						subjects involved in this study and that the information will not
						be reused or disclosed to third parties unless required by law for
						authorized oversight of the research study.<br></td>
					<td><input type="radio" id="id15" name="bool8" value="Yes15"
						disabled>Yes <input type="radio" id="id16" name="bool8"
						value="No16" disabled>No</td>
				</tr>
				<tr>
					<td colspan="2" align="center" style="padding-left: 60px"
						valign="top"><input name="submitHIPAAWaiver" type="submit"
						value="Submit HIPAA Waiver" style="width: 20%; font-size: 1.0em;"
						class="btn btn-large btn btn-success btn-lg btn-block" /></td>
				</tr>
			</tbody>
		</table>
	</FORM>
</body>
</html>