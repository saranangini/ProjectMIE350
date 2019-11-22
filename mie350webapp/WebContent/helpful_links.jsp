<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - Other Links</title>
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
				<h1>Other Links</h1>


				<u><b>Sample HTML Tags</b></u>

				<ul>
					<li>HTML Tags Example: <a href="sample_html.jsp">Example
							Page in this Web App</a></li>
					<li>HTML Tutorial: <a
						href="http://www.w3schools.com/html/default.asp">http://www.w3schools.com/html/default.asp</a></li>
				</ul>

				<u><b>BootStrap Tutorial</b></u>

				<ul>
					<li>BootStrap CSS Tutorial: <a
						href="http://www.w3schools.com/bootstrap/">http://www.w3schools.com/bootstrap/</a></li>
					<li>This BootStrap Theme: <a
						href="https://startbootstrap.com/template-overviews/clean-blog/">https://startbootstrap.com/template-overviews/clean-blog/</a></li>
				</ul>

				<p>As well, below are some links that may be of use.</p>

				<u><b>Java Server Pages (JSP)</b></u>

				<ul>
					<li>JSP - Actions: <a
						href="http://www.tutorialspoint.com/jsp/jsp_actions.htm">http://www.tutorialspoint.com/jsp/jsp_actions.htm</a></li>
					<li>JSP - Form Processing: <a
						href="http://www.tutorialspoint.com/jsp/jsp_form_processing.htm">http://www.tutorialspoint.com/jsp/jsp_form_processing.htm</a></li>
					<li>JSP - Shopping Cart: <a
						href="https://www.ntu.edu.sg/home/ehchua/programming/java/JavaServletCaseStudyPart2.html">https://www.ntu.edu.sg/home/ehchua/programming/java/JavaServletCaseStudyPart2.html</a>
					</li>
				</ul>

				<u><b>HyperText Markup Language (HTML)</b></u>
				<ul>
					<li>W3Schools' HTML Tutorial: <a
						href="http://www.w3schools.com/html/default.asp" target="_blank">http://www.w3schools.com/html/default.asp</a></li>
					<li>Overview of basic HTML tags: <a
						href="http://www.htmlcodetutorial.com/document/" target="_blank">http://www.htmlcodetutorial.com/document/</a></li>
					<li>Mozilla's Introduction to HTML: <a
						href="https://developer.mozilla.org/en-US/docs/HTML/Introduction"
						target="_blank">https://developer.mozilla.org/en-US/docs/HTML/Introduction</a></li>
				</ul>

				<u><b>Cascading Style Sheets (CSS)</b></u>
				<ul>
					<li>W3Schools' CSS Tutorial: <a
						href="http://www.w3schools.com/css/default.asp" target="_blank">http://www.w3schools.com/css/default.asp</a></li>
					<li>Overview of style sheets: <a
						href="http://www.htmlcodetutorial.com/css/css.html"
						target="_blank">http://www.htmlcodetutorial.com/css/css.html</a></li>
					<li>Mozilla's CSS Tutorial for Beginners: <a
						href="https://developer.mozilla.org/en-US/docs/CSS/Getting_Started"
						target="_blank">https://developer.mozilla.org/en-US/docs/CSS/Getting_Started</a></li>
					<li>W3C's Tutorial on Starting with HTML + CSS: <a
						href="http://www.w3.org/Style/Examples/011/firstcss.en.html"
						target="_blank">http://www.w3.org/Style/Examples/011/firstcss.en.html</a></li>
				</ul>
				<p>
					<br />Please keep in mind that the overall <b><i><span
							style="text-decoration: underline;">functionality</span> </i></b>of your
					web application is more important than aesthetics, so don't spend
					too much time making your web applications pretty!
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
