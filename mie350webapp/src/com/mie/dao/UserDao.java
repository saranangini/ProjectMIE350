 package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.User;
import com.mie.util.DbUtil;

public class UserDao {
	/**
	 * This class handles all of the User-related methods
	 * (add/update/delete/get).
	 */

	private Connection connection;

	public UserDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	
	
//make this for add member which admins and users can do - takes in raw data from new accnt form
	public void addUser(User User) {
		/**
		 * This method adds a new User to the database.
		 */
		
		//OKAY SOMEHOW we need to make it loop back to ask the person to re-enter their info
		if (getUsernames(getAllUsers()).contains(User.getUsername())){
			
			System.out.println("This username already exists, pick a new one my guy"); //NOT SURE IF THIS WORKS
		
		} else{
			try {
				
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into Users(username,password,firstname,lastname,email,age,address,city,phoneNum,active) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
				// Parameters start with 1
				preparedStatement.setString(1, User.getUsername());
				preparedStatement.setString(2, User.getPassword());
				preparedStatement.setString(3, User.getFirstName());
				preparedStatement.setString(4, User.getLastName());
				preparedStatement.setString(5, User.getEmail());
				preparedStatement.setString(4, String.valueOf(User.getAge()));
				preparedStatement.setString(7, User.getAddress());
				preparedStatement.setString(8, User.getCity());
				preparedStatement.setString(7, String.valueOf(User.getPhoneNum()));
				preparedStatement.setString(10, "true");
				
				preparedStatement.executeUpdate();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public List<String> getUsernames(List<User> userlist){ //this is gross i know im sorry but lemme know if theres a better way
		
		List<String> usernamelist = new ArrayList<String>();
		
		for (User u:userlist){
			usernamelist.add(u.getUsername());
		}
	
		return usernamelist;
		
	}

	public void deleteUser(User User) { //this used to take in String username so will probably break something (watch out!)
		//hi tanishq here -- yeah it limits the functionality of deleteUser in UserController
		//
		/**
		 * This method sets a user's activity status to false.
		 */
		
		User.setActive(false);
		try {
/*			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Users where username=?");
			// Parameters start with 1
			preparedStatement.setString(1, username);
			preparedStatement.executeUpdate();*/
			
			PreparedStatement preparedStatement = connection.prepareStatement("update Users set active=? where username =?");
			preparedStatement.setString(1, String.valueOf(User.getActive()));
			preparedStatement.setString(2, User.getUsername());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User User) {
		/**
		 * This method updates a User's information into the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Users set firstname=?, lastname=?, email=?, age=?, password=?, address=?, city=?, phoneNum=?"
							+ " where username=?");
			// Parameters start with 1
			
			preparedStatement.setString(1, User.getFirstName());
			preparedStatement.setString(2, User.getLastName());
			preparedStatement.setString(3, User.getEmail());
			preparedStatement.setString(4, String.valueOf(User.getAge()));
			preparedStatement.setString(5, User.getAddress());
			preparedStatement.setString(6, User.getCity());
			preparedStatement.setString(7, String.valueOf(User.getPhoneNum()));
			preparedStatement.setString(8, User.getPassword());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<User> getAllUsers() {
		/**
		 * This method returns the list of all Users in the form of a List
		 * object.
		 */
		List<User> Users = new ArrayList<User>();
		try {
			Statement statement = connection.createStatement();
			// System.out.println("getting Users from table");
			ResultSet rs = statement.executeQuery("select * from Users");
			while (rs.next()) {
				User User = new User();
				User.setUsername(rs.getString("username"));
				User.setFirstName(rs.getString("firstname"));
				User.setLastName(rs.getString("lastname"));
				User.setEmail(rs.getString("email"));
				User.setAge(rs.getInt("age"));
				User.setAddress(rs.getString("address"));
				User.setCity(rs.getString("city"));
				User.setPhoneNum(rs.getInt("phoneNum"));
				User.setActive(Boolean.parseBoolean(rs.getString("active"))); //why doesn't this work fuck you -- IT DOES NOW
				
				
				Users.add(User);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Users;
	}

/*	public User getUserById(int Userid) {
		*//**
		 * This method retrieves a User by their UserID number.
		 * 
		 * Currently not used in the sample web app, but code is left here for
		 * your review.
		 *//*
		User User = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Users where Userid=?");
			preparedStatement.setInt(1, Userid);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				//User.setUserid(rs.getInt("Userid"));
				User.setFirstName(rs.getString("firstname"));
				User.setLastName(rs.getString("lastname"));
				User.setAge(rs.getInt("age"));
				User.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return User;
	}*/

	public User getUserByUsername(String Username) {

		User User = new User();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Users where username=?");
			preparedStatement.setString(1, Username);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				User.setUsername(rs.getString("username"));
				User.setFirstName(rs.getString("firstname"));
				User.setLastName(rs.getString("lastname"));
				User.setEmail(rs.getString("email"));
				User.setAge(rs.getInt("age"));
				User.setAddress(rs.getString("address"));
				User.setCity(rs.getString("city"));
				User.setPhoneNum(rs.getInt("phoneNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return User;
	}
	
	public List<User> getUserByKeyword(String keyword) {
		/**
		 * This method retrieves a list of Users that matches the keyword
		 * entered by the user.
		 */
		List<User> Users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Users where firstname LIKE ? OR lastname LIKE ? OR username LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User User = new User();
				User.setUsername(rs.getString("username"));
				User.setFirstName(rs.getString("firstname"));
				User.setLastName(rs.getString("lastname"));
				User.setEmail(rs.getString("email"));
				User.setAge(rs.getInt("age"));
				User.setAddress(rs.getString("address"));
				User.setCity(rs.getString("city"));
				User.setPhoneNum(rs.getInt("phoneNum"));
				
				Users.add(User);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Users;
	}

}