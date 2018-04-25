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
<title>Study Page</title>
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
		<font size="6" class="div" color="cornsilk" style="padding-left:40px;">IRB Study</font>
	</h1>
	<a href="/irb_approval_request/LogoutServlet" style="float: top;padding-left: 1400px;"><font
		size="2" class="div" color="cornsilk">Logout</font></a>
	<form name="study" method="post" action="StudyServlet">
		<input type="hidden" name="studyname" value="studyName" />
		<table style="height: 600px; background-color: #10B7C6;"
			align="center" width="95%" cellpadding="0" cellspacing="0">
			<tr>
				<td align="left" style="padding-left: 490px" valign="bottom"><b><font
						color="black" style="font-family: fantasy;">Principal
							Investigator: </font></b></td>
				<td align="left" style="padding-right: 490px" valign="bottom">
					<%
				String invstigator = (String) session.getAttribute("investigator");
				String projectTitle = (String) session.getAttribute("projTitle");
				String institutionName = (String) session.getAttribute("institution");
				System.out.println("invstigator:"+invstigator);
				System.out.println("projectTitle:"+projectTitle);
				System.out.println("institution:"+institution);
				if (invstigator != null && !invstigator.isEmpty()) {
				%> <input type="text" name="investigator" value="<%=invstigator%>"
					size="40" height="20px" /> <%
				}else{
				%> <input type="text" name="investigator" size="40" height="20px" />
					<%}%>
				</td>
			</tr>
			<tr style="height: 50px">
				<td align="left" style="padding-left: 500px" valign="center"><b><font
						color="black" style="font-family: fantasy;">Project Title:
					</font></b></td>
				<td align="left" style="padding-right: 500px" valign="center">
					<%
				if (projectTitle != null && !projectTitle.isEmpty()) {
				%> <input type="text" name="projTitle" value="<%=projectTitle%>"
					size="40" height="20px" /> <%
				}else{
				%> <input type="text" name="projTitle" size="40" height="20px" /> <%}%>
				</td>
			</tr>
			<tr style="height: 50px">
				<td align="left" style="padding-left: 500px" valign="center"><b><font
						color="black" style="font-family: fantasy;">Institution:
					</font></b></td>
				<td align="left" style="padding-right: 500px" valign="center">
					<%
				if (institutionName != null && !institutionName.isEmpty()) {
				%> <input type="text" name="institution" value="<%=institutionName%>"
					size="40" height="20px" /> <%
				}else{
				%> <input type="text" name="institution" size="40" height="20px" /> <%}%>
				</td>
			</tr>
			<tr>
				<td align="left" style="padding-left: 500px" valign="top"></td>
					<td align="left" style="padding-right: 500px"  valign="top"><input
					name="createStudy" type="submit" value="Create Study"
					style="width: 50%; font-size: 1.0em;"
					class="btn btn-large btn btn-success btn-lg btn-block" /></td>
			</tr>
		</table>
		<%
		  String studyPage = (String) session.getAttribute("noStudyDetails");

		if (studyPage != null && studyPage.equals("noStudyDetails")) {
		
			if ((invstigator == null || invstigator.isEmpty()) && (projectTitle == null || projectTitle.isEmpty()) && (institutionName == null || institutionName.isEmpty())){
		%>
		<div style="color: red">Please Enter all the fields</div>
		<%
			}else if ((invstigator == null || invstigator.isEmpty()) && (projectTitle == null || projectTitle.isEmpty())) {
		%>
		<div style="color: red">Please Enter Principal Investigator and Project Title</div>
		<%
			}else if ((invstigator == null || invstigator.isEmpty()) && (institutionName == null || institutionName.isEmpty())) {
		%>
		<div style="color: red">Please Enter Principal Investigator and Institution</div>
		<%
			}else if ((institutionName == null || institutionName.isEmpty()) && (projectTitle == null || projectTitle.isEmpty())) {
		%>
		<div style="color: red">Please Enter Project Title and Institution</div>
		<%
			}else if (invstigator == null || invstigator.isEmpty()) {
		%>
		<div style="color: red">Please Enter Principal Investigator</div>
		<%
			}else if (projectTitle == null || projectTitle.isEmpty()) {
		%>
		<div style="color: red">Please Enter Project Title</div>
		<%
			}else if (institutionName == null || institutionName.isEmpty()) {
		%>
		<div style="color: red">Please Enter Institution</div>
		<%}
		}
		session.removeAttribute("investigator");
			session.removeAttribute("projTitle");
			session.removeAttribute("institution");
			session.removeAttribute("noStudyDetails");
			 %>
	</form>
</body>
</html>
