<div class="col-sm-2 sidenav">
	<!-- You can put left sidebar links here if you want to. -->
	<!-- Eclipse will underline the first name, last name, and user name variables as errors
	but you can ignore them since this JSP file will be imported by another JSP 
	file that handles the variable declarations (see memberLogged.jsp for example).
	 -->
	Welcome, <b><%=firstname%> <%=lastname%></b> (username: <b><%=username%></b>).<br />
	<br />You are now logged in with <b>administrative</b> privileges.<br />
	<br /> The time is now <b><%=new java.util.Date()%></b>.<br /> <br />
	You will be logged out after 15 minutes of inactivity.<br /> <br />
	The log out button can be found on the upper right section of the
	navigation bar.
</div>