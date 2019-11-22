package com.mie.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.model.*;
import com.mie.dao.*;

/**
 * Servlet implementation for LoginController.
 * 
 * This class handles the login servlet and assigns session attributes for users
 * who succesfully log into the system.
 */
public class LoginController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/**
		 * Retrieve the entered username and password from the login.jsp form.
		 */
		Member member = new Member();
		member.setUsername(request.getParameter("un"));
		member.setPassword(request.getParameter("pw"));

		try {
			/**
			 * Try to see if the member can log in.
			 */
			member = MemberDao.login(member);

			/**
			 * If the isValid value is true, assign session attributes to the
			 * current member.
			 */
			if (member.isValid()) {

				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionmember", member);
				session.setAttribute("username", member.getUsername());
				session.setAttribute("firstname", member.getFirstName());
				session.setAttribute("lastname", member.getLastName());
				/**
				 * Redirect to the members-only home page.
				 */
				response.sendRedirect("memberLogged.jsp");

				/**
				 * Set a timeout variable of 900 seconds (15 minutes) for this
				 * member who has logged into the system.
				 */
				session.setMaxInactiveInterval(900);
			}

			else {
				/**
				 * Otherwise, redirect the user to the invalid login page and
				 * ask them to log in again with the proper credentials.
				 */
				response.sendRedirect("invalidLogin.jsp");
			}
		}

		catch (Throwable theException) {
			/**
			 * Print out any errors.
			 */
			System.out.println(theException);
		}
	}
}
