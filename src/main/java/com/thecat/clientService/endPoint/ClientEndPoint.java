package com.thecat.clientService.endPoint;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thecat.clientService.entities.User;
import com.thecat.clientService.entities.UserJson;
import com.thecat.clientService.services.impl.ClientService;


/**
 * API use to manage interaction with the database
 *
 * @author froberge
 * @since September 2018
 */
@Path("/clients")
public class ClientEndPoint {

    /**
     * Select a given user from the database, Only the username will be return.
     *
     * @param {@link UserJson} user
     * @return {@link UserJson}
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path( "/select" )
    public Response selectUser(UserJson user) {
        if (user != null) {
            User u = ClientService.getInstance().findUser( user.getEmailAdr(), user.getPassword() );

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
    @Path( "/create" )
    public Response registerUser(UserJson user) {
        if (user != null) {
            
        	boolean b = ClientService.getInstance().insertAUser( user );

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
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path( "/createSchema" )
    public Response createSchema() {
		boolean b = ClientService.getInstance().createSchema();

		if (b) {
			return Response.ok().entity( "Database was successfully created" ).build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST)
					.entity("Could not create database")
					.build();
		}
    }
}
