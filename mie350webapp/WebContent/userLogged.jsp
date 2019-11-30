<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR" import="com.mie.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<!-- Check to see if the user is logged in. Otherwise, redirect back to the login page.-->
<%
	session = request.getSession();
	System.out.println(session);
	if (session.getAttribute("username") == null) {
		response.sendRedirect("login.jsp");
	}
%>

<head>
<title>Online Giving Community Site - User Home</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<!-- Date Picker Javascript -->
<!-- https://jqueryui.com/datepicker/ -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet" type="text/css" href="css/mystyle.css">
</head>
<body>

	<%@ include file="navbar_loggedin.jsp"%>

	<%
		Member member = (Member) session.getAttribute("currentSessionUser");

		String username = (String) session.getAttribute("username");
		String firstname = (String) session.getAttribute("firstname");
		String lastname = (String) session.getAttribute("lastname");
	%>

	<div class="container-fluid text-center">
		<div class="row content">
			<%@ include file="sidebar_loggedin.jsp"%>
			<div class="col-sm-8 text-left">

				<h1>
					Welcome,
					<%=firstname%>
					<%=lastname%>!
				</h1>


				Welcome!.

				<h2>Members-Only Features</h2>
				From your profile, you can do the following:

				<ul>
					<li><b>Browse</b> charities and events</li>
					<li><b>Save</b> events that you are interested in</li>
					<li><b>Confirm</b> events that you will be attending</li>
					<li><b>View</b> your upcoming events</li>
					<li><b>View</b> your account information and <b>Delete</b> your account</li>
				</ul>


			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>