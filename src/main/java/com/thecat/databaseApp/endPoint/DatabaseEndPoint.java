package com.thecat.databaseApp.endPoint;

import com.thecat.databaseApp.entities.User;
import com.thecat.databaseApp.entities.UserJson;
import com.thecat.databaseApp.services.impl.DatabaseService;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Service use to Login into the application
 *
 * @author froberge
 * @since Oct 2016
 */
@Path("/login")
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
    public Response loginPost(UserJson user) {
        if (user != null) {
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
