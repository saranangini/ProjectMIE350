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
//make this for ad meber which admins and users can do - takes in raw data from new accnt form
	public void addUser(User User) {
		/**
		 * This method adds a new User to the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into Users(firstname,lastname,dob,email) values (?, ?, ?, ? )");
			// Parameters start with 1
			preparedStatement.setString(1, User.getFirstName());
			preparedStatement.setString(2, User.getLastName());
			preparedStatement.setString(3, String.valueOf(User.getAge()));
			preparedStatement.setString(4, User.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteUser(int Userid) {
		/**
		 * This method deletes a User from the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Users where Userid=?");
			// Parameters start with 1
			preparedStatement.setInt(1, Userid);
			preparedStatement.executeUpdate();

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
					.prepareStatement("update Users set firstname=?, lastname=?, dob=?, email=?"
							+ " where Userid=?");
			// Parameters start with 1
			preparedStatement.setString(1, User.getFirstName());
			preparedStatement.setString(2, User.getLastName());
			preparedStatement.setString(3, String.valueOf((User.getAge())));
			preparedStatement.setString(4, User.getEmail());
			//preparedStatement.setInt(5, User.getUserid());
			preparedStatement.executeUpdate();

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
				//User.setUserid(rs.getInt("Userid"));
				User.setFirstName(rs.getString("firstname"));
				User.setLastName(rs.getString("lastname"));
				User.setAge(rs.getInt("age"));
				User.setEmail(rs.getString("email"));
				Users.add(User);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Users;
	}

	public User getUserById(int Userid) {
		/**
		 * This method retrieves a User by their UserID number.
		 * 
		 * Currently not used in the sample web app, but code is left here for
		 * your review.
		 */
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
	}

	public List<User> getUserByKeyword(String keyword) {
		/**
		 * This method retrieves a list of Users that matches the keyword
		 * entered by the user.
		 */
		List<User> Users = new ArrayList<User>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Users where firstname LIKE ? OR lastname LIKE ? OR email LIKE ? OR dob LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");
			preparedStatement.setString(4, "%" + keyword + "%");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				User User = new User();
				//User.setUserid(rs.getInt("Userid"));
				User.setFirstName(rs.getString("firstname"));
				User.setLastName(rs.getString("lastname"));
				User.setAge(rs.getInt("age"));
				User.setEmail(rs.getString("email"));
				Users.add(User);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Users;
	}

}