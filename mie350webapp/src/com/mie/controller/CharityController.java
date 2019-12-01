package com.mie.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mie.dao.CharityDao;
import com.mie.dao.UserDao;
import com.mie.model.Charity;
import com.mie.model.User;

public class CharityController {
	/**
	 * This class handles all insert/edit/list functions of the servlet.
	 * 
	 * These are variables that lead to the appropriate JSP pages. INSERT leads
	 * to the Add A User page. EDIT leads to the Edit A User page.
	 * LIST_User_PUBLIC leads to the public listing of Users.
	 * LIST_User_ADMIN leads to the admin-only listing of Users (for them
	 * to modify User information).
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static String INSERT = "/addCharity.jsp";
	private static String EDIT = "/editCharity.jsp";
	private static String LIST_Charity_PUBLIC = "/listCharityPublic.jsp";
	private static String LIST_Charity_ADMIN = "/listCharityAdmin.jsp";

	private CharityDao dao;

	/**
	 * Constructor for this class.
	 */
	public CharityController() {
		super();
		dao = new CharityDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This class retrieves the appropriate 'action' found on the JSP pages:
		 * 
		 * - delete will direct the servlet to let the user delete a User in
		 * the database. - insert will direct the servlet to let the user add a
		 * new User to the database. - edit will direct the servlet to let
		 * the user edit User information in the database. - listUser will
		 * direct the servlet to the public listing of all Users in the
		 * database. - listUserAdmin will direct the servlet to the admin
		 * listing of all Users in the database.
		 */
		String forward = "";
		String action = request.getParameter("action");

		//if (action.equalsIgnoreCase("delete")) {
			//String charityName = request.getParameter("CharityName");
			//Charity charity = dao.getCharityByCharityname(charityName);
			//dao.deleteCharity(charity); //change to take a user as opposed to a username OR adjust deleteUser to take a username again (call User object in 
			//hi tanishq here -- i think i fixed what you were concerned about by adding the line above it
			
			forward = LIST_Charity_ADMIN;
			request.setAttribute("Charity", dao.getAllCharities());
		
		if (action.equalsIgnoreCase("insert")) {
			forward = INSERT;
		
		} else if (action.equalsIgnoreCase("edit")) {
			forward = EDIT;
			String charityname = request.getParameter("charityname");
			Charity Charity = dao.getCharityByCharityname(charityname);
			request.setAttribute("Charity", Charity);
		
		} else if (action.equalsIgnoreCase("listCharity")) {
			forward = LIST_Charity_PUBLIC;
			request.setAttribute("Charity", dao.getAllCharities());
		//charity list views are the same for both admins & users
		} else {
			forward = INSERT;
		}

		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		/**
		 * This method retrieves all of the information entered in the form on
		 * the addUser.jsp or the editUser.jsp pages.
		 */
		Charity Charity = new Charity();
		
		Charity.setCharityID(Integer.parseInt(request.getParameter("charityID")));
		Charity.setCharityName(request.getParameter("charityName"));
		Charity.setCharityCategory((request.getParameter("category")));
		Charity.setCity(request.getParameter("city"));
		Charity.setAddress(request.getParameter("address"));
		Charity.setHours(request.getParameter("phoneNum"));
		Charity.setPhoneNum(Integer.parseInt(request.getParameter("phoneNum")));
		
		int charityid  = Integer.parseInt(request.getParameter("charityID"));
		
		if (CharityDao.charityExists(charityid)== false){
			dao.addCharity(Charity);
		}
		else {
			Charity.setCharityID(charityid);
			dao.updateCharity(Charity);
		}
/*		
		User.setFirstName(request.getParameter("firstName"));
		User.setLastName(request.getParameter("lastName"));
		try {
			Date dob = new SimpleDateFormat("MM/dd/yyyy").parse(request
					.getParameter("dob"));
			User.setDob(dob);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		User.setEmail(request.getParameter("email"));
		String Userid = request.getParameter("Userid");
		*//**
		 * If the 'Userid' field in the form is empty, the new User will
		 * be added to the list of User objects.
		 *//*
		
		if (Userid == null || Userid.isEmpty()) {
			dao.addUser(User);
		} else {
			*//**
			 * Otherwise, if the field is already filled (this occurs when the
			 * user is trying to Edit A User), then the User's information
			 * will be updated accordingly.
			 *//*
			User.setUserid(Integer.parseInt(Userid));
			dao.updateUser(User);
		}
		
		
		
		*/
		/**
		 * Once the User has been added or updated, the page will redirect to
		 * the listing of Users.
		 */
		RequestDispatcher view = request
				.getRequestDispatcher(LIST_Charity_ADMIN);
		request.setAttribute("Charity", dao.getAllCharities());
		view.forward(request, response);
	}
}
