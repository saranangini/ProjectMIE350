package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Admin;
import com.mie.model.Charity;
import com.mie.model.Member;
import com.mie.model.User;
import com.mie.model.Charity;
import com.mie.model.Charity;
import com.mie.util.DbUtil;

public class CharityDao {
	
	/**
	 * This class handles the Charity objects ???
	 */
	
	
	private Connection connection;
	static Connection currentCon = null;
	static ResultSet rs = null;

	public CharityDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public void deleteCharity(Charity Charity) { //this used to take in String username so will probably break something (watch out!)
		//hi tanishq here -- yeah it limits the functionality of deleteUser in UserController
		//
		/**
		 * This method sets a user's activity status to false.
		 */
		
		//.setActive(false);
		try {
/*			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from Users where username=?");
			// Parameters start with 1
			preparedStatement.setString(1, username);
			preparedStatement.executeUpdate();*/
			
			PreparedStatement preparedStatement = connection.prepareStatement("update Users set active=? where username =?");
			//preparedStatement.setString(1, String.valueOf(User.getActive()));
			preparedStatement.setString(2, Charity.getCharityName());

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Charity> getAllCharities() {
		/**
		 * This method returns the list of all Charities in the form of a List
		 * object.
		 */
		List<Charity> Charities = new ArrayList<Charity>();
		try {
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from Charities");
			while (rs.next()) {
				Charity Charity = new Charity();
				
				Charity.setCharityID(rs.getInt("charityID"));
				Charity.setAddress(rs.getString("address"));
				Charity.setCharityCategory(rs.getString("charityCategory"));
				Charity.setCharityName(rs.getString("charityName"));
				Charity.setCity(rs.getString("city"));
				Charity.setHours(rs.getString("hours"));
				Charity.setPhoneNum(rs.getInt("phoneNum"));
				
				Charities.add(Charity);
				
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Charities;
	}
	
public static boolean charityExists(int charityid) {
		
		String searchQuery = "Select * from Charities where charityID='" + charityid + "'";
		Statement stmt = null;

		try {
			// connect to DB
			currentCon = DbUtil.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(searchQuery);
			return(rs.next());
		}

		catch (Exception ex) {
			System.out.println("Log In failed: An Exception has occurred! "
					+ ex);
			return(false);
		}
		
	}

	public void addCharity(Charity Charity) {
		/**
		 * This method adds a new User to the database.
		 */
		
		//OKAY SOMEHOW we need to make it loop back to ask the person to re-enter their info
		/*if (getUsernames(getAllUsers()).contains(User.getUsername())){
			
			System.out.println("Dude this username already exists, pick a new one my guy"); //NOT SURE IF THIS WORKS
		
		} else{*/
			try {
				
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into Users(username,password,firstname,lastname,email,age,address,phoneNum,active) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				// Parameters start with 1
				preparedStatement.setInt(1, Charity.getCharityID());
				preparedStatement.setString(2, Charity.getCharityName());
				preparedStatement.setString(3, Charity.getCharityCategory());
				preparedStatement.setString(4, Charity.getCity());
				preparedStatement.setString(5, Charity.getAddress());
				preparedStatement.setString(6, Charity.getHours());
				preparedStatement.setInt(7, Charity.getPhoneNum());
				
				
				preparedStatement.executeUpdate();
	
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
	public Charity getCharityByCharityname(String CharityName) {

		Charity Charity = new Charity();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Charities where charityName=?");
			preparedStatement.setString(1, CharityName);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Charity.setCharityID(rs.getInt("charityID"));
				Charity.setAddress(rs.getString("address"));
				Charity.setCharityCategory(rs.getString("charityCategory"));
				Charity.setCharityName(rs.getString("charityName"));
				Charity.setCity(rs.getString("city"));
				Charity.setHours(rs.getString("hours"));
				Charity.setPhoneNum(rs.getInt("phoneNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Charity;
	}
	
	public void updateCharity(Charity Charity) {
		/**
		 * This method updates a User's information into the database.
		 */
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update Users set firstname=?, lastname=?, email=?, age=?, address=?, phoneNum=?"
							+ " where username=?");
			// Parameters start with 1
			
			preparedStatement.setString(1, Charity.getCharityName());
			preparedStatement.setString(2, Charity.getCharityCategory());
			preparedStatement.setString(3,Charity.getCity());
			preparedStatement.setString(4, Charity.getAddress());
			preparedStatement.setString(5, Charity.getHours());
			preparedStatement.setString(7, String.valueOf(Charity.getPhoneNum()));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Charity> getCharityByKeyword(String keyword) {
		/**
		 * This method retrieves a list of Charities that matches the keyword
		 * entered by the user.
		 */
		List<Charity> Charities = new ArrayList<Charity>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Charities where charityName LIKE ? OR charityCategory LIKE ? OR city LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Charity Charity = new Charity();
				
				Charity.setCharityID(rs.getInt("charityID"));
				Charity.setAddress(rs.getString("address"));
				Charity.setCharityCategory(rs.getString("charityCategory"));
				Charity.setCharityName(rs.getString("charityName"));
				Charity.setCity(rs.getString("city"));
				Charity.setHours(rs.getString("hours"));
				Charity.setPhoneNum(rs.getInt("phoneNum"));
				
				Charities.add(Charity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Charities;
	}
	
}