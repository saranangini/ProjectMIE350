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
import com.mie.model.Charity;
import com.mie.model.Charity;
import com.mie.util.DbUtil;

public class CharityDao {
	
	/**
	 * This class handles the Charity objects ???
	 */
	
	
	private Connection connection;

	public CharityDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
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