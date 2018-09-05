package com.thecat.databaseService.endPoint;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.thecat.databaseService.entities.Product;
import com.thecat.databaseService.entities.User;
import com.thecat.databaseService.entities.UserJson;
import com.thecat.databaseService.services.impl.DatabaseService;

import java.util.List;

/**
 * API use to manage interaction with the database
 *
 * @author froberge
 * @since September 2018
 */
@Path("/db")
public class DatabaseEndPoint {

    /**
     * Select a given user from the database, Only the username will be return.
     *
     * @param {@link UserJson} user
     * @return {@link UserJson}
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path( "/users/select" )
    public Response selectUser(UserJson user) {
        if (user != null) {
            User u = DatabaseService.getInstance().selectUser(user.getEmailAdr(), user.getPassword());

            if (u == null) {
                return Response.status(Response.Status.BAD_REQUEST).entity( "Can't find user" ).build();
            } else {
                UserJson uj = new UserJson();
                uj.setUsername(u.getName());

                return Response.ok()
                        .entity(uj)
                        .build();
            }
        } else {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity("No user specify")
                    .build();
        }
    }

    /**
     * register action 
     *
     * @param {@link UserJson} user
     * @return
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path( "/users/register" )
    public Response registerUser(UserJson user) {
        if (user != null) {
            
        	boolean b = DatabaseService.getInstance().registerUser(user);

            if (b ) {
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity( "Could not Register, please try again" )
                        .build();
            }
        } else {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity("No user specify")
                    .build();
        }
    }

    /**
     * register action
     *
     * @param {@link UserJson} user
     * @return
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path( "/createdb" )
    public Response createDatabase() {
		boolean b = DatabaseService.getInstance().createDatabase();

		if (b) {
			return Response.ok().entity( "Database was successfully created" ).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Could not create database")
					.build();
		}
    }

    /**
     * Select all the product from the database
     *
     * @param {@link UserJson} user
     * @return {@link UserJson}
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path( "/products/selectAll" )
    public Response selectProducts() {

        List<Product> listProduct = DatabaseService.getInstance().selectAllProduct();

        if (listProduct == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity( "No product Found" ).build();
        } else {
            System.out.print( "list product size : " + listProduct.size() );

            return Response.ok()
                    .entity(listProduct)
                    .build();
        }
    }

    /**
     * Select all the product from the database
     *
     * @param {@link UserJson} user
     * @return {@link UserJson}
     */
    @GET
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path( "/products" )
    public List<Product> selectProducts() {

        return DatabaseService.getInstance().selectAllProduct();
    }



}
