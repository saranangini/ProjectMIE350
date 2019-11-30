package com.mie.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mie.model.Admin;
import com.mie.model.User;
import com.mie.util.DbUtil;

public class AdminDao {
	
	
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public static Admin login(Admin admin) {

		/**
		 * This method attempts to find the member that is trying to log in by
		 * first retrieving the username and password entered by the user.
		 */
		Statement stmt = null;

		String username = admin.getUsername();
		String password = admin.getPassword();

		/**
		 * Prepare a query that searches the members table in the database
		 * with the given username and password.
		 */
		String searchQuery = "select * from admin where username='"
				+ username + "' AND password='" + password + "'";

		try {
			// connect to DB
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			boolean more = rs.next();

			/**
			 * If there are no results from the query, set the member to false.
			 * The person attempting to log in will be redirected to the home
			 * page when isValid is false.
			 */
			
			if (!more) {
				admin.setValid(false);
			}
			
			/**
			 * If the query results in an database entry that matches the
			 * username and password, assign the appropriate information to
			 * the Member object.
			 */
			else if (more) {

				admin.setUsername(rs.getString("username"));
				admin.setFirstName(rs.getString("firstname"));
				admin.setLastName(rs.getString("lastname"));
				admin.setEmail(rs.getString("email"));
				admin.setAdmin(true);
				admin.setValid(true);
			}
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
		}
		/**
		 * Return the Member object.
		 */
		return admin;

		}

}
