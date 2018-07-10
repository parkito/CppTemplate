package ru.siksmfp.ejb.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.siksmfp.ejb.crud.entity.UserEntity;
import ru.siksmfp.ejb.crud.service.UsersService;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Artem Karnov @date 7/9/2018.
 * @email artem.karnov@t-systems.com
 */
@Path(value = "user")
@Stateless
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @EJB
    private UsersService usersService;

    @GET
    @Path(value = "/find/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity getUserByEmail(@PathParam("email") String email) {
        LOGGER.error(email);
       return usersService.findUserByEmail(email);
    }

    @PUT
    @Path(value = "/delete/{email}")
    public void deleteUserByEmail(@PathParam("email") String email) {
        usersService.deleteUser(email);
    }

    @POST
    @Path(value = "/create")
    public void createUser(String email, String firstName, String secondName, String password) {
        usersService.createUser(email, firstName, secondName, password);
    }
}
