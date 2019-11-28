package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Admin;
import com.mie.util.DbUtil;
//Modeled this class after member and user DAO
public class AdminDao {
	/**
	 * This class handles all of the User-related methods
	 * (add/update/delete/get).
	 */

	private Connection connection;

	public AdminDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public void addAdmin(Admin Admin) {
		/**
		 * This method adds a new User to the database.
		 */
		
		//OKAY SOMEHOW we need to make it loop back to ask the person to re-enter their info
		if (getUsernames(getAllAdmins()).contains(Admin.getUsername())){
			
			System.out.println("This username already exists, pick a new one my guy"); //NOT SURE IF THIS WORKS
		
		} else{
			try {
				
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into Users(username,password,firstname,lastname,email,age,address,city,phoneNum,active) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				// Parameters start with 1
				preparedStatement.setString(1, Admin.getUsername());
				preparedStatement.setString(2, Admin.getPassword());
				preparedStatement.setString(3, Admin.getFirstName());
				preparedStatement.setString(4, Admin.getLastName());
				preparedStatement.setString(5, Admin.getEmail());
				preparedStatement.setString(6, Admin.isAdmin());
				
				preparedStatement.executeUpdate();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public List<String> getUsernames(List<Admin> adminlist){ //this is gross i know im sorry but lemme know if theres a better way
		
		List<String> usernamelist = new ArrayList<String>();
		
		for (Admin a:adminlist){
			usernamelist.add(a.getUsername());
		}
	
		return usernamelist;
		
	}

	public void updateAdmin(Admin Admin) {
	/**
	 * This method updates a User's information into the database.
	 */
	try {
		PreparedStatement preparedStatement = connection
				.prepareStatement("update Admins set firstname=?, lastname=?, email=?, password=?, admin=? " + " where username=?");
		// Parameters start with 1
		
		preparedStatement.setString(1, Admin.getFirstName());
		preparedStatement.setString(2, Admin.getLastName());
		preparedStatement.setString(3, Admin.getEmail());
		preparedStatement.setString(4, Admin.getPassword());
		preparedStatement.setString(5, Admin.isAdmin());
		
	} catch (SQLException e) {
		e.printStackTrace();
		}
	}
	
	public List<Admin> getAllAdmins() {
		/**
		 * This method returns the list of all Admins in the form of a List
		 * object.
		 */
		List<Admin> Admins = new ArrayList<Admin>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting Users from table");
			ResultSet rs = statement.executeQuery("select * from Admins");
			while (rs.next()) {
				Admin Admin = new Admin();
				Admin.setUsername(rs.getString("username"));
				Admin.setFirstName(rs.getString("firstname"));
				Admin.setLastName(rs.getString("lastname"));
				Admin.setEmail(rs.getString("email"));
				Admin.setAdmin((rs.getString("true"))); //assuming all admins are valid and that all admins are set to true for isadmin
				
				
				Admins.add(Admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Admins;
	}
	
	public Admin getAdminByUsername(String Username) {

		Admin Admin = new Admin();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Admins where username=?");
			preparedStatement.setString(1, Username);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Admin.setUsername(rs.getString("username"));
				Admin.setFirstName(rs.getString("firstname"));
				Admin.setLastName(rs.getString("lastname"));
				Admin.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Admin;
	}
	
	public List<Admin> getAdminByKeyword(String keyword) {
		/**
		 * This method retrieves a list of Users that matches the keyword
		 * entered by the user.
		 */
		List<Admin> Admins = new ArrayList<Admin>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Admins where firstname LIKE ? OR lastname LIKE ? OR username LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Admin Admin = new Admin();
				Admin.setUsername(rs.getString("username"));
				Admin.setFirstName(rs.getString("firstname"));
				Admin.setLastName(rs.getString("lastname"));
				Admin.setEmail(rs.getString("email"));
				
				Admins.add(Admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Admins;
	}

}
