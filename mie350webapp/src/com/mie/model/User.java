package com.mie.model;


public class User extends Member{
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the User object.
	 */

	private int age;
	private String address;
	private String city;
	private String phoneNum;
	private boolean active;
	
	public User(){
		this.admin=false;
	}
	//add address 
	//add valid 
	//member super user sub
	//public int getUserid() {
		//return userid;
	//}

	//public void setUserid(int Userid) {
		//this.userid = Userid;
	//}
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String Address){
		this.address=Address;
	}
	
	public String getCity(){
		return city;
	}
	
	public void setCity(String City){
		this.city=City;
	}
	
	public void setPhoneNum(String PhoneNum){
		this.phoneNum=PhoneNum;
	}
	
	public String getPhoneNum(){
		return phoneNum;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int userAge) {
		this.age = userAge;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getActive(){
		return active;
	}
	
	public void setActive(boolean Active){
		this.active = Active;
	}

	@Override
	public String toString() {
		return "User [Userid=" + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + ", email="
				+ email + ", address=" +address+ ", city=" +city+ ",phone number=" +phoneNum+"]";
	}
}