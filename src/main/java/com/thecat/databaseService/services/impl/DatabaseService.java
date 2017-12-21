/**
 * 
 */
package com.thecat.databaseService.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.thecat.databaseService.entities.User;

/**
 * Implement the Login Service
 *
 * @author froberge
 * @since Oct 25, 2016
 */
public class DatabaseService {

	private static DatabaseService dbService = null;
	
	private List<User> userList;
	
	/**
	 * Private constructor to prevent the creation of the LoginService
	 */
	private DatabaseService(){
		// Initialize the userList
		this.userList = createUserList();
	}
	
	public static DatabaseService getInstance() {
		if ( dbService == null ) {
			dbService = new DatabaseService();
		}

		return dbService;
	}


	/**
	 * Find a given user.
	 * 
	 * @param emailAdress {@link String}
	 * @param password {@link String}
	 * @return {@link User}
	 */
	public User findAUser(String emailAdress, String password) {
		
		System.out.println( "User list " + userList.size() );

		return this.userList.stream().filter( u -> ( u.getEmailAddress().equals(emailAdress)
				&& u.getPassword().equals(password) ) ).findFirst().orElse(null);
	}
	
	
	/**
	 * Create a basic list of customer.
	 * @return {@link ArrayList}
	 */
	private List<User> createUserList() {
	    List<User> list = new ArrayList<User>();
	    list.add(
	        new User(
	        "test",
	        User.Gender.FEMALE,
	        LocalDate.now().minusYears(17),
	        "test@example.com",
	        "test"));
	    list.add(
	        new User(
	        "test123",
	        User.Gender.MALE,
	        LocalDate.now().minusYears(30),
	        "test@example.com",
	        "test"));
	    list.add(
	        new User(
	        "test456",
	        User.Gender.MALE,
	        LocalDate.now().minusYears(30),
	        "test@example.com",
	        "test"));	    
	    
	    return list;
	}
}
