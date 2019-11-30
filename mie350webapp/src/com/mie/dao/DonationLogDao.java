package com.mie.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   
import com.mie.model.Admin;
import com.mie.model.Event;
import com.mie.model.Member;
import com.mie.model.Event;
import com.mie.model.Event;
import com.mie.util.DbUtil;


public class DonationLogDao {
	
	private ArrayList<Integer> numEvents; 
	private ArrayList<String> responses;
	private HashMap<Integer, String> pastEventsMap;
	private Connection connection;
	static Connection currentCon = null;
	static ResultSet rs = null;

	public DonationLogDao() {
		/**
		 * Get the database connection.
		 */
		connection = DbUtil.getConnection();
		numEvents=new ArrayList<Integer>();
		responses=new ArrayList<String>();
		pastEventsMap=new HashMap<Integer, String >();
	}
	
	public HashMap<Integer,String> getAllPastEventsInMap() {
		/**
		 * This method returns the list of all Events in the form of a List
		 * object.
		 */
		

		//Date today = Calendar.getInstance().getTime();

		List<Event> TaggedEvents = new ArrayList<Event>();
		try {
			Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("select * from TaggedEvents");
			while (rs.next()) {
				
				Event Event = new Event();
				
				Event.setEventID(rs.getInt("EventID"));
				Event.setCharityID(rs.getInt("charityID"));
				Event.setDonationType(rs.getString("donationType"));
				Event.setEventName(rs.getString("eventName"));
				Event.setCity(rs.getString("city"));
				Event.setEventDate(rs.getDate("eventDate")); //yáll we gotta make sure this is real
				Event.setResponse("response"); //ooo i added this and i don't know
				
				TaggedEvents.add(Event);
			for(Event e:TaggedEvents){
				//Date firstDate2 = new (2019, 11, 30);
				Date today=new Date(2019,11,30);
 
				if(e.getEventDate().after(today) && e.getResponse()=="Going"){
				pastEventsMap.put(e.getEventID(), e.getResponse());	//so we get a hashmap of event IDs and responses
				}
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pastEventsMap;
	}
	
	
	
	
	
}
