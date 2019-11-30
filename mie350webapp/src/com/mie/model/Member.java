  
package com.mie.model;


public class Member {
	/**
	 * This class contains all of the relevant information, and getter/setter
	 * methods for the Member object.
	 */
	//private int memberid; //member ID and User ID for creation, modification & deletion of accnt
	protected String firstName;
	protected String lastName;
	protected String username;
	protected String password;
	protected String email;
	protected boolean valid; //if the accnt exists
	protected boolean admin; //if member
	
	
	//public int getMemberid() {

		//return memberid;
	//}

	//public void setMemberid(int memberid) {
		//this.memberid = memberid;
	//}

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean newValid) {
		valid = newValid;
	}
	
	public void setAdmin(boolean newAdmin){ //new admin will tell if login is admin
		admin=newAdmin;
	}
	
	public boolean isAdmin(){
		return admin;
	}

	@Override
	public String toString() {
		return "Member [userid=" + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", username=" + username
				+ ", password=" + password + ", email=" + email + "]";
	}
}