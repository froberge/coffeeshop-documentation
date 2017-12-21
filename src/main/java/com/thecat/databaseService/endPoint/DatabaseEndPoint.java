package com.thecat.databaseService.endPoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.thecat.databaseService.entities.User;
import com.thecat.databaseService.entities.UserJson;
import com.thecat.databaseService.services.impl.DatabaseService;

/**
 * Service use to manage interaction with the database
 *
 * @author froberge
 * @since Oct 2017
 */
@Path("/db")
public class DatabaseEndPoint {


    /**
     * Endpoint responsible to login a user
     *
     * @param {@link UserJson} user
     * @return
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path( "/select" )
    public Response findAUser(UserJson user) {
        if (user != null) {
        	System.out.println( "user not empty " + user.toString() );
            User u = DatabaseService.getInstance().findAUser(user.getEmailAdr(), user.getPassword());

            if (u == null) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Wrong Username or Password")
                        .build();
            } else {
                return Response.ok()
                        .entity(parseResponse(u))
                        .build();
            }
        } else {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity("No user specify")
                    .build();
        }
    }

    /**
     * Parse the the response to a proper JSON element.
     *
     * @param u {@link User}
     * @return {@link UserJson}
     */
    private UserJson parseResponse(User u) {
        UserJson uj = new UserJson();
        uj.setAge(Integer.toString(u.getAge()));
        uj.setEmailAdr(u.getEmailAddress());
        uj.setGender(u.getGender().name());
        uj.setPassword(u.getPassword());
        uj.setUsername(u.getName());

        return uj;
    }
}
