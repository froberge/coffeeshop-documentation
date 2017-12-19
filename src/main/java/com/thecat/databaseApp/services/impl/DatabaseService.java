/**
 * 
 */
package com.thecat.databaseApp.services.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.thecat.databaseApp.entities.User;

/**
 * Implement the Login Service
 *
 * @author froberge
 * @since Oct 25, 2016
 */
public class DatabaseService {

	private static DatabaseService dbService = null;
	
	/**
	 * Private constructor to prevent the creation of the LoginService
	 */
	private DatabaseService(){
		
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

		return listAllUser().stream().filter( u -> ( u.getEmailAddress().equals(emailAdress)
				&& u.getPassword().equals(password) ) ).findFirst().orElse(null);
	}
	
	
	/**
	 * List all the user inside the database
	 * 
	 * @return {@link List}
	 */
	public List<User> listAllUser() {
		return createUserList();
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
