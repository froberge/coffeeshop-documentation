/**
 * 
 */
package com.thecat.databaseService.services.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

import com.thecat.databaseService.entities.User;
import com.thecat.databaseService.entities.UserJson;

/**
 * Implement the Database Service
 *
 * @author froberge
 * @since September, 2018
 */
public class DatabaseService {

	private static DatabaseService dbService = null;
	
	/**
	 * Private constructor to prevent the creation of the DatabaseService
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
	 *  This method create a connection to the database.
	 *
	 * @return {@link Connection}
	 * @throws Exception
	 */
	private Connection getDatabaseConnection() throws Exception{
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
	 * Create the database schea needed for the coffee shop user and the product to start with.
	 * This is a work around to speed things up.
	 *
	 * @return boolean
	 */
	public boolean createDatabase() {

		boolean response = false;
		String scriptFile = "dbscripts/creationScript.sql";
		BufferedReader in = null;

		try {
			Connection connection = getDatabaseConnection();

			if (connection != null) {
				Statement stmt = connection.createStatement();
				in = new BufferedReader(new FileReader( scriptFile ) );
				String line;
				StringBuffer sb = new StringBuffer();

				//Read the script
				while ((line = in.readLine()) != null) {
					sb.append(line + "\n ");
				}

				in.close();
				stmt.executeUpdate(sb.toString());
				response = true;
			}
		} catch( Exception e ) {
			System.out.println("problem creating the script \n " + e.getMessage());
		}

		return response;
	}

	/**
	 * Find a given user.
	 * 
	 * @param emailAddress {@link String}
	 * @param password {@link String}
	 * @return {@link User}
	 */
	public User selectUser(String emailAddress, String password) {
		User response = null;
		
		try {		
			Connection connection = getDatabaseConnection();

			if ( connection != null ) {
				String query = "select * from USERS where emailadr = ? and password = ?";
				PreparedStatement stmt = connection.prepareStatement(query);
				
				stmt.setString(1, emailAddress);
				stmt.setString(2, password);
				
				ResultSet rs = stmt.executeQuery();
				
				while (rs.next() ) {
					response = new User();
					response.setName( rs.getString( "NAME" ) );
				}
				
				rs.close();
				connection.close();
				return response;
			} else {
				System.out.println( "no connection" );
			}
		} catch (Exception e ) {
			System.out.println( e );
		}
		
		return response;
	}

	/**
	 * Insert a new user in the database.
	 *
	 * @param user {@link UserJson}
	 * @return boolean
	 */
	public boolean registerUser(UserJson user) {
		boolean response = false;

		try {
			Connection connection = getDatabaseConnection();

			if ( connection != null ) {
				String query = "INSERT INTO USERS " +
						"(ID, NAME, GENDER, BIRTHDATE, EMAILADR, PASSWORD, CREATE_DATE) " +
						"VALUES " +
						"(nextval('users_seq'), ?,?,to_date(?,'yyyy/mm/dd'),?,?,to_date(?,'yyyy/mm/dd'))";

				PreparedStatement stmt = connection.prepareStatement(query);

				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getGender());
				stmt.setString(3, user.getAge());
				stmt.setString(4, user.getEmailAdr());
				stmt.setString(5, user.getPassword());
				stmt.setString(6, LocalDateTime.now().toString());

				stmt.executeUpdate();
				connection.close();

				response =  true;
			} else {
				System.out.println( "no connection" );
			}
		} catch (Exception e ) {
			System.out.println( e );
		}

		return response;
	}
}
