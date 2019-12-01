package com.mie.dao;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;

	import com.mie.model.Admin;
	import com.mie.model.Event;
	import com.mie.model.Member;
	import com.mie.model.Event;
	import com.mie.model.Event;
	import com.mie.util.DbUtil;

	public class TaggedEventsDao {

			/**
			 * This class handles the Event objects ???
			 */
			
			
		private Connection connection;
		private ArrayList<Integer> numEvents; 
		private ArrayList<String> responses;
		private HashMap<Integer, String> taggedEventsMap;
		
		public TaggedEventsDao() {
				/**
				 * Get the database connection.
				 */
				connection = DbUtil.getConnection();
				numEvents=new ArrayList<Integer>();
				responses=new ArrayList<String>();
				taggedEventsMap=new HashMap<Integer, String >();
				
			}
		public HashMap<Integer,String> getAllTaggedEventsInMap() {
				/**
				 * This method returns the list of all Events in the form of a List
				 * object.
				 */
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
						taggedEventsMap.put(e.getEventID(), e.getResponse());	//so we get a hashmap of event IDs and responses
						}
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}

				return taggedEventsMap;
			}
		
		
	}
