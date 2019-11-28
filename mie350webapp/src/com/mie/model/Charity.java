package com.mie.model;

public class Charity {

	
	private int charityID;
	private String charityName;
	private String charityCategory;
	private String city;
	private String address;
	private String hours;
	private int phoneNum;
	
	public int getCharityID(){
		return charityID;
	}
	
	public void setCharityID(int CharityID){
		this.charityID = CharityID;
	}
	
	public String getCharityName(){
		return charityName;
	}
	
	public void setCharityName(String CharityName){
		this.charityName = CharityName;
	}
	
	public String getCharityCategory(){
		return charityCategory;
	}
	
	public void setCharityCategory(String CharityCategory){
		this.charityCategory = CharityCategory;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String City){
		this.city=City;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String Address){
		this.address=Address;
	}
	
	public String getHours(){
		return hours;
	}
	
	public void setHours(String Hours){
		this.hours = Hours;
	}
	
	public void setPhoneNum(int PhoneNum){
		this.phoneNum=PhoneNum;
	}
	
	public int getPhoneNum(){
		return phoneNum;
	}
}