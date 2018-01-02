package com.thecat.databaseService.entities;

import java.time.LocalDate;
import java.time.Period;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Simple object representing a user, use and a representation of a DB entry.
 *
 * @author froberge
 * @since December 2017
 */
@XmlRootElement
public  class User {

	public enum Gender {
        MALE, FEMALE
    }

    private String name;
    
    private Gender gender;
    
    private LocalDate birthDate;
    
	private String emailAddress;
	
	private String password;
	

    /**
     * Default constructor
     */
    public User() {
    }
    
    /**
     * Creste a User with the different field needed
     * 
     * @param name {@link String}
     * @param gender {@link Gender} 
     * @param birthDate {@link LocalDate}
     * @param emailAddress {@link String}
     * @param password {@link String}
     */
    public User( String name, Gender gender, LocalDate birthDate, String emailAddress, String password ) {
		super();
		
		this.name = name;
		this.gender = gender;
		this.birthDate = birthDate;
		this.emailAddress = emailAddress;
		this.password = password;
	}
    
    /**
     * @return {@link String} 
     */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @param name {@link String}
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return {@link Gender}
	 */
    public Gender getGender() {
		return this.gender;
	}

	/**
	 * @return {@link LocalDate}
	 */
	public LocalDate getBirthDate() {
		return this.birthDate;
	}

	/**
	 * @param birthDate {@link LocalDate}
	 */
	public void setBirthdate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}    
    
	/**
	 * @return {@link String}
	 */
	public String getEmailAddress() {
		return this.emailAddress;
	}

	/**
	 * @param emailAddress {@link String}
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}    
	
	/**
	 * @return {@link String}
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @param password {@link String}
	 */
	public void setPassword(String password) {
		this.password = password;
	} 
	
	/**
	 * This will calculate the age of the person from the user date of birth.
	 * 
	 * @return int
	 */
	public int getAge() {
		LocalDate currentDate = LocalDate.now();
		Period p = Period.between(this.birthDate, currentDate);
		
		return p.getYears();
	}
	    
    /**
     * Return a representation of the customer information in a formated String
     */
    public String toString() {
    	
    	StringBuffer sb = new StringBuffer( "Information on the client: \n" );
    	
    	sb.append("name [ " + this.name + "]\n");
    	sb.append("gender [ " + this.gender + "]\n");
    	sb.append("birthDate [ " + this.birthDate.toString() + "]\n");
    	sb.append("email [ " + this.emailAddress + "]\n");
    	sb.append("password [ " + this.password + "]\n");
    	
    	return sb.toString();
     }
}
