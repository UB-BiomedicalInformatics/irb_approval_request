<%@ page language="java" contentType="text/html; charset=windows-1256"
	pageEncoding="windows-1256"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<jsp:useBean id="studyID" type="java.lang.Integer" scope="session" />
<jsp:useBean id="investigator" type="java.lang.String" scope="session" />
<jsp:useBean id="projTitle" type="java.lang.String" scope="session" />
<jsp:useBean id="institution" type="java.lang.String" scope="session" />

<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1256">
<title>Human Research Page</title>
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
		<font size="6" class="div" color="cornsilk" style="padding-left:40px;">IRB Human Research
			Form: Study Id:<%=session.getAttribute("studyID")%>
		</font>
	</h1>
	<a href="/irb_approval_request/LogoutServlet" style="float: top;padding-left: 1400px;"><font
		size="2" class="div" color="cornsilk">Logout</font></a>
	<form name="humanResearch" method="post" action="HumanResearchServlet">
		<input type="hidden" name="humanResearchName"
			value="humanResearchName" />
		<table class="table table-bordered"
			style="height: 600px; background-color: #10B7C6;" align="center"
			width="95%" cellpadding="0" cellspacing="0">
				<tr>
					<td colspan="2"><font size="4">1. <b><font
								color="blue"><u>Research</u></font> as Defined by DHHS
								Regulations</b> (Check if <b>“Yes”</b>.)
					</font><br></td>
				</tr>
				<tr>
					<td>1a. Is the activity an <font color="blue"><u>investigation</u></font>?
						(<font color="blue"><u>Investigation</u></font>: A searching
						inquiry for facts; detailed or careful examination.)<br></td>
					<td width="100px"><input type="radio" name="attr1"
						value="Yes1">Yes <input type="radio" name="attr1"
						value="No2">No</td>
				</tr>
				<tr>
					<td>1b. Is the investigation <font color="blue"><u>systematic?</u></font>
						(<font color="blue"><u>Systematic</u></font>: Having or involving
						a system, method, or plan.) <br>
					</td>
					<td><input type="radio" name="attr2" value="Yes3">Yes
						<input type="radio" name="attr2" value="No4">No</td>
				</tr>
				<tr>
					<td>1c. Is the systematic investigation <font color="blue"><u>designed</u></font>
						to <font color="blue"><u>develop</u></font> or <font color="blue"><u>contribute</u></font>
						to <font color="blue"><u>knowledge</u></font>? (<font color="blue"><u>Designed</u></font>:
						observable behaviors used to <font color="blue"><u>develop</u></font>
						or <font color="blue"><u>contribute</u></font> to knowledge. <font
						color="blue"><u>Develop</u></font>: to form the basis for a future
						contribution. <font color="blue"><u>Contribute</u></font>: to
						result in. <font color="blue"><u>Knowledge</u></font>: truths,
						facts, information.) <br>
					</td>
					<td><input type="radio" name="attr3" value="Yes5">Yes
						<input type="radio" name="attr3" value="No6">No</td>
				</tr>
				<tr>
				<tr>
					<td>1d. Is the knowledge the systematic investigation is
						designed to develop or contribute <font color="blue"><u>generalizable</u></font>?
						(<font color="blue"><u>Generalizable</u></font>: Universally or
						widely applicable.)<br>
					</td>
					<td><input type="radio" name="attr4" value="Yes7">Yes
						<input type="radio" name="attr4" value="No8">No</td>
				</tr>
				<tr>
					<td colspan="10"><b>2. <font color="blue"><u>Human
									Subject</u></font> Under DHHS Regulations
					</b> (Check if <b>“Yes”</b>.)<br></td>
				</tr>
				<tr>
					<td>2a. Is the investigator conducting the <font color="blue"><u>Research</u></font>
						gathering data about living individuals? <br>
					</td>
					<td><input type="radio" name="attr5" value="Yes9">Yes
						<input type="radio" name="attr5" value="No10">No</td>
				</tr>
				<tr>
					<td colspan="10"><b>3. <b><font color="blue"><u>Human
										Subject</u></font> Under DHHS Regulations</b> (Check if <b>“Yes”</b>.)<br>
					</b></td>
				</tr>
				<tr>
					<td colspan="10">3a. Will the investigator gather that data through either
						of the following mechanisms(specify which mechanism(s) apply):<br>
					</td>
					</tr>
				<tr>
					<td>3a1. Physical procedures or manipulations of those
						individuals or their environment for research purposes
						(“intervention”).<br>
					</td>
					<td><input type="radio" name="attr6" value="Yes11">Yes
						<input type="radio" name="attr6" value="No12">No</td>
				</tr>
				<tr>
					<td>3a2. Communication or interpersonal contact with the
						individuals. (“interaction”).<br>
					</td>
					<td><input type="radio" name="attr7" value="Yes13">Yes
						<input type="radio" name="attr7" value="No14">No</td>
				</tr>
				<tr>
					<td colspan="10"><b>4. <b><font color="blue"><u>Human
										Subject</u></font> Under DHHS Regulations</b> (Check if <b>“Yes”</b>.)<br>
					</b></td>
				</tr>
				<tr>
					<td>4a. Can individuals reasonably expect that their
						information will <b>NOT</b> be made public, such as a medical
						record (i.e. <font color="blue"><u>“Private
								information”</u></font>).<br>
					</td>
					<td><input type="radio" name="attr8" value="Yes15">Yes
						<input type="radio" name="attr8" value="No16">No</td>
				</tr>
				<tr>
					<td colspan="10"><b>If all items are checked under 1,2,
							and 3 or 1,2 and 4,the activity is <font color="blue"><u>Human
									Research</u></font> under DHHS regulations.
					</b><br></td>
				</tr>
				<tr>
					<td colspan="10"><b>5. <b><font color="blue"><u>Human
										Subject</u></font> Under FDA Regulations</b> (Check if <b>“Yes”</b>.)<br>
					</b></td>
				</tr>
				<tr>
					<td>5a. Will the study use a drug on a patient.<br>
					</td>
					<td><input type="radio" name="attr9" value="Yes17">Yes
						<input type="radio" name="attr9" value="No18">No</td>
				</tr>
				<tr>
					<td>5b. Will the study use a device on a patient.<br>
					</td>
					<td><input type="radio" name="attr10" value="Yes19">Yes
						<input type="radio" name="attr10" value="No20">No</td>
				</tr>
				<tr>
					<td>5c. Data regarding subjects or control subjects submitted
						to or held for inspection by FDA.<br>
					</td>
					<td><input type="radio" name="attr11" value="Yes21">Yes
						<input type="radio" name="attr11" value="No22">No</td>
				</tr>
				<tr>
					<td>5d. Data regarding the use of a device on human specimens
						(identified or unidentified) submitted to or held for inspection
						by FDA.<br>
					</td>
					<td><input type="radio" name="attr12" value="Yes23">Yes
						<input type="radio" name="attr12" value="No24">No</td>
				</tr>
				<tr>
					<td colspan="10">If <b>“Yes”</b>, the activity is <font
						color="blue"><u>Human Research</u></font> under FDA regulations.<br></td>
				</tr>
				<tr>
					<td colspan="10"><b>If the activity is <font color="blue"><u>Human
									Research</u></font> under DHHS regulations or under FDA regulations, it is
							<font color="blue"><u>Human Research</u></font> under
							organizational policy.
					</b><br></td>
				</tr>
				<tr>
					<td align="center" colspan="2" style="padding-left: 60px"
						valign="top"><input name="submitHumanResearch" type="submit"
						value="Submit Human Research"
						style="width: 20%; font-size: 1.0em;"
						class="btn btn-large btn btn-success btn-lg btn-block" /></td>
				</tr>
		</table>
	</form>
</body>
</html>