package com.thecat.databaseService.entities;

public class UserJson {

	private String username;
	private String password;
	private String emailAdr;
	private String gender;
	private String age;

    /**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the emailAdr
	 */
	public String getEmailAdr() {
		return emailAdr;
	}

	/**
	 * @param emailAdr the emailAdr to set
	 */
	public void setEmailAdr(String emailAdr) {
		this.emailAdr = emailAdr;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	
    public String toString() {
    	
    	StringBuffer sb = new StringBuffer( "Information on the client: \n" );
    	
    	sb.append("name [ " + this.username + "]\n");
    	sb.append("gender [ " + this.gender + "]\n");
    	sb.append("birthDate [ " + this.age + "]\n");
    	sb.append("email [ " + this.emailAdr + "]\n");
    	
    	return sb.toString();
     }
}