<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<title>MIE350 Sample Web App - Sample HTML Tags</title>
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
				<h1>Sample HTML Tags</h1>

				This page outlines basic HTML tags you can use to decorate your web
				app pages.<br /> <br />

				<blockquote>
					<b>This is bolded text.</b><br> &lt;b&gt;This is bolded
					text.&lt;/b&gt;
				</blockquote>

				<blockquote>
					<i>This is italicized text.</i><br> &lt;i&gt;This is
					italicized text.&lt;/i&gt;
				</blockquote>

				<blockquote>
					<u>This is underlined text.</u><br> &lt;u&gt;This is
					underlined text.&lt;/u&gt;
				</blockquote>

				<blockquote>
					This text contains<br>a line break.<br> This text
					contains&lt;br&gt;a line break.
				</blockquote>
				<br />

				<table style="width: 100%" border style="1">

					<tr>
						<td>Jill</td>
						<td>Smith</td>
						<td>50</td>
					</tr>
					<tr>
						<td>Eve</td>
						<td>Jackson</td>
						<td>94</td>
					</tr>
				</table>
				<br /> <br />
				<div class="w3-code notranslate htmlHigh">
					&lt;table style=&quot;width:100%&quot; border style=&quot;1&quot;
					&gt;<br> &nbsp; &lt;tr&gt;<br>&nbsp; &nbsp;
					&lt;td&gt;Jill&lt;/td&gt;<br> &nbsp;&nbsp;&nbsp;
					&lt;td&gt;Smith&lt;/td&gt; <br>&nbsp;&nbsp;&nbsp;
					&lt;td&gt;50&lt;/td&gt;<br> &nbsp; &lt;/tr&gt;<br>&nbsp;
					&lt;tr&gt;<br>&nbsp;&nbsp;&nbsp; &lt;td&gt;Eve&lt;/td&gt;<br>
					&nbsp;&nbsp;&nbsp; &lt;td&gt;Jackson&lt;/td&gt; <br>&nbsp;&nbsp;&nbsp;
					&lt;td&gt;94&lt;/td&gt;<br> &nbsp; &lt;/tr&gt;<br>&lt;/table&gt;
				</div>

			</div>
			<div class="col-sm-2 sidenav">
				<!-- You can put right sidebar links here if you want to. -->
			</div>
		</div>
	</div>

	<%@ include file="footer.jsp"%>


</body>
</html>