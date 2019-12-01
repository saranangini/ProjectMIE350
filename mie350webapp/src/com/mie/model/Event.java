package com.mie.model;

import java.util.Date;

public class Event {

	private int eventID;
	private String eventName;
	private int charityID;
	private Date eventDate;
	private String donationType;
	private String city;
	
	public int getEventID(){
		return eventID;
	}
	
	public void setEventID(int EventID){
		this.eventID = EventID;
	}
	
	public String getEventName(){
		return eventName;
	}

	public void setEventName(String EventName){
		this.eventName = EventName;
	}
	
	public int getCharityID(){
		return charityID;
	}
	
	public void setCharityID(int CharityID){
		this.charityID = CharityID;
	}
	
	public Date getEventDate(){
		return eventDate;
	}
	
	public void setEventDate(Date EventDate){
		this.eventDate = EventDate;
	}
	
	public String getDonationType(){
		return donationType;
	}
	
	public void setDonationType(String DonationType){
		this.donationType = DonationType;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String City){
		this.city=City;
	}
}