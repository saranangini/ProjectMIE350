<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App</title>
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

	<%@ include file="navbar.jsp"%>



	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<!-- You can put left sidebar links here if you want to. -->
			</div>
			<div class="col-sm-8 text-left">
				<h1>Welcome</h1>
				<p>In this project, your team will design and build a web
					application. A web application is a software application that is
					accessed over the Internet using standard browsers (e.g. Internet
					Explorer, Mozilla Firefox). Examples of web application would be
					online-shopping, web banking, stock exchange and many others. Each
					member of the team is expected to contribute equally to the project
					though there may be a variety of different roles.</p>
				<hr>
				<h3>Internet Browsers</h3>
				<p>When designing your projects, please make sure to test them
					with the following browsers:
				<ul>
					<li>Google Chrome</li>
					<li>Mozilla Firefox</li>
					<li>Internet Explorer (or Microsoft Edge)</li>
				</ul>
				Please <b>do not rely on the built-in web browser in Eclipse</b> for
				testing. Cascading Style Sheet (CSS) templates will not render
				properly with Eclipse's built-in browser.
				</p>
			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>
