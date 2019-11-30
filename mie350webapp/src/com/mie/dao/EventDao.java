package com.mie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mie.model.Admin;
import com.mie.model.Event;
import com.mie.model.Member;
import com.mie.model.Event;
import com.mie.model.Event;
import com.mie.util.DbUtil;

public class EventDao {
	
	/**
	 * This class handles the Event objects ???
	 */
	
	
	private Connection connection;

	public EventDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
	}
	
	public List<Event> getAllEvents() {
		/**
		 * This method returns the list of all Events in the form of a List
		 * object.
		 */
		List<Event> Events = new ArrayList<Event>();
		try {
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from Events");
			while (rs.next()) {
				Event Event = new Event();
				
				Event.setEventID(rs.getInt("EventID"));
				Event.setCharityID(rs.getInt("charityID"));
				Event.setDonationType(rs.getString("donationType"));
				Event.setEventName(rs.getString("eventName"));
				Event.setCity(rs.getString("city"));
				Event.setEventDate(rs.getDate("eventDate")); //yáll we gotta make sure this is real
				
				Events.add(Event);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Events;
	}
	
	public Event getEventByEventname(String EventName) {

		Event Event = new Event();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Events where EventName=?");
			preparedStatement.setString(1, EventName);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				Event.setEventID(rs.getInt("EventID"));
				Event.setCharityID(rs.getInt("charityID"));
				Event.setDonationType(rs.getString("donationType"));
				Event.setEventName(rs.getString("eventName"));
				Event.setCity(rs.getString("city"));
				Event.setEventDate(rs.getDate("eventDate")); //yáll we gotta make sure this is real
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Event;
	}
	
	public List<Event> getEventByKeyword(String keyword) {
		/**
		 * This method retrieves a list of Events that matches the keyword
		 * entered by the user.
		 */
		List<Event> Events = new ArrayList<Event>();
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from Events where EventName LIKE ? OR EventCategory LIKE ? OR city LIKE ?");

			preparedStatement.setString(1, "%" + keyword + "%");
			preparedStatement.setString(2, "%" + keyword + "%");
			preparedStatement.setString(3, "%" + keyword + "%");

			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Event Event = new Event();
				
				Event.setEventID(rs.getInt("EventID"));
				Event.setCharityID(rs.getInt("charityID"));
				Event.setDonationType(rs.getString("donationType"));
				Event.setEventName(rs.getString("eventName"));
				Event.setCity(rs.getString("city"));
				Event.setEventDate(rs.getDate("eventDate")); //yáll we gotta make sure this is real
				
				Events.add(Event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Events;
	}
	
}