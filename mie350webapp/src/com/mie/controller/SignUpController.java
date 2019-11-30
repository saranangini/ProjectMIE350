package com.mie.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mie.model.*;
import com.mie.dao.*;

public class SignUpController extends HttpServlet{

	private UserDao dao;
	
	public SignUpController() {
		super();
		dao = new UserDao();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		/**
		 * Retrieve the entered username and password from the login.jsp form.
		 */
		Member member = new Member();
		User user = new User();
		String username = request.getParameter("user");
		
		
		
		List<String> existingusers = dao.getAllUsernames();
		
		if (existingusers.contains(username)){
			response.sendRedirect("chooseNewUser.jsp");	
		}
		else{
		
		
			user.setUsername(username);
			user.setPassword(request.getParameter("pass"));
			user.setFirstName(request.getParameter("fname"));
			user.setLastName(request.getParameter("lname"));
			user.setAge(Integer.parseInt(request.getParameter("age")));
			user.setAddress(request.getParameter("address"));
			user.setPhoneNum(request.getParameter("phonenum"));
			user.setEmail(request.getParameter("email"));
			user.setActive(true);
			user.setValid(true);
			
			dao.addUser(user);
			
			response.sendRedirect("userLogin.jsp");

		
		}
	
	
	}
	
	
}
