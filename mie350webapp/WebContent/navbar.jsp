<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp">MIE350 Sample Web App</a>
		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="index.jsp">Home</a></li>
				<li><a href="about.jsp">About</a></li>
				<li><a
					href="/mie350webapp/StudentController?action=listStudent">Charity List</a></li>
				<li><a href="searchStudent.jsp">Find an Event</a></li>
				<li class="dropdown"><a data-toggle="dropdown"
					href="helpful_links.jsp">Other Links<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="sample_html.jsp">Sample HTML Tags</a></li>
						<li><a href="helpful_links.jsp">Other Helpful Links</a></li>
						<li><a href="http://www.w3schools.com/html/default.asp">HTML
								Tutorial</a></li>
						<li><a href="http://www.w3schools.com/bootstrap/">BootStrap
								CSS Tutorial</a></li>
					</ul></li>
				<li><a href="contact.jsp">Contact</a></li>
			</ul>
			<!-- The following code can be added to include a Login button to the right-hand side of the navbar-->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="signup.jsp"><span
						class="glyphicon glyphicon-plus"></span> Sign Up </a>				
				
				<li><a href="userLogin.jsp"><span
						class="glyphicon glyphicon-log-in"></span> Login</a></li>


			</ul>

		</div>
	</div>
</nav>