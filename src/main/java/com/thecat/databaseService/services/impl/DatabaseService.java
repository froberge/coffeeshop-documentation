/**
 * 
 */
package com.thecat.databaseService.services.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.http.ConnectionClosedException;

import com.thecat.databaseService.entities.User;
import com.thecat.databaseService.entities.UserJson;

/**
 * Implement the Database Service
 *
 * @author froberge
 * @since December, 2017
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
	public User select(String emailAdress, String password) {

		try {		
			Connection connection = connectToDatabase();

			if ( connection != null ) {
				System.out.println( "connection sucessful" );

				createaUserTable( connection );
							
				String sql = "select * from USERS";
				Statement stmt = connection.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				System.out.println( "number of row " + rs.getRow() );
				
				while (rs.next() ) {
					System.out.println( "check element name: " + rs.getString( "NAME" ) );
				}
				
				rs.close();
				connection.close();
				 
			} else {
				System.out.println( "no connection" );
			}
		} catch (Exception e ) {
			System.out.println( e );
		}
		
		// Select from the user list if no database
		return selectUserFromList(emailAdress, password);
	}

	public User selectUserFromList(String emailAdress, String password) {
		return this.userList.stream().filter( u -> ( u.getEmailAddress().equals(emailAdress)
			&& u.getPassword().equals(password) ) ).findFirst().orElse(null);
	}
	
	/**
	 * Add a new user for a system
	 * 
	 * @param user {@link UserJson}
	 * @return {@link Boolean}
	 */
	public boolean register(UserJson user) {
		//Register from the user list if no database
		addUserToList(user);
		
		return true;
	}

	

	/**
	 * Create a basic list of customer instead of using a database.
	 * @return {@link ArrayList}
	 */
	private List<User> createUserList() {
	    List<User> list = new LinkedList<User>();
	    list.add(
	        new User(
	        "test",
	        User.Gender.FEMALE,
	        LocalDate.now().minusYears(17),
	        "test@example.com",
	        "test"));
	    
	    return list;
	}
	
	/**
	 * Register a given user.
	 * 
	 * @param users {@link UserJson}
	 * @return 
	 */
	private void addUserToList(UserJson user) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		
		this.userList.add(
	        new User(
	        user.getUsername(),
	        User.Gender.valueOf(user.getGender().toUpperCase()),
	        LocalDate.parse(user.getAge(), formatter),
	        user.getEmailAdr(),
	        user.getPassword()));
	}
	
	/**
	 *  This method create a connection to the databse.
	 *  
	 * @return {@link Connection}
	 * @throws Exception
	 */
	private Connection connectToDatabase() throws Exception{
		StringBuffer dbUrl = new StringBuffer( "jdbc:postgresql://" );
		dbUrl.append( System.getenv( "POSTGRESQL_SERVICE_HOST" ) );
		dbUrl.append( "/" );
		dbUrl.append( System.getenv( "POSTGRESQL_DATABASE" ) );
		
		
		String username = System.getenv( "POSTGRESQL_USER" );
		String password = System.getenv( "PGPASSWORD" );
		
		try {
				
			Connection connection = DriverManager.getConnection( dbUrl.toString(), username, password ); 
			
			if ( connection != null ) {
				return connection; 
			} else {
				return null;
			}
		} catch ( Exception e ) {
			throw e;
		}
	}

	/**
	 * CMethod that create a new table and a sequence into the database for the user.
	 * 
	 * @param connection {@link Connection}
	 * @throws SQLException
	 */
	private void createaUserTable(Connection connection) throws SQLException {
		Statement stmt = connection.createStatement();
		String createSequence = "CREATE SEQUENCE users_seq "
				+ "START WITH 1 "
				+ "INCREMENT BY   1";
		
		stmt.executeUpdate(createSequence);
		System.out.println( "sequence is created" );
		
		
		String createTable = "CREATE TABLE USERS " +
			    "(ID INT NOT NULL, " +
			    "NAME VARCHAR(100) NOT NULL, " +
			    "GENDER VARCHAR(6) NOT NULL, " +
			    "BIRTHDATE DATE, " +
			    "EMAILADR VARCHAR(100) NOT NULL, " +
			    "PASSWORD  VARCHAR(20)  NOT NULL, " +
			    "CREATE_DATE DATE, " + 
			    "PRIMARY KEY (ID))";

		
		stmt.executeUpdate(createTable);
		System.out.println( "table is created" );
	}
}
