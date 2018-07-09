package ru.siksmfp.ejb.crud.controller;

import ru.siksmfp.ejb.crud.entity.UserEntity;
import ru.siksmfp.ejb.crud.service.UsersService;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Artem Karnov @date 4/17/2018.
 * @email artem.karnov@t-systems.com
 */
@Path(value = "/user")
public class UserController {

    @EJB
    private UsersService usersService;

    @GET
    @Path(value = "/find")
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntity getUserByEmail(String email) {
        return usersService.findUserByEmail(email);
    }

    @PUT
    @Path(value = "/delete")
    public void deleteUserByEmail(String email) {
        usersService.deleteUser(email);
    }

    @POST
    @Path(value = "/create")
    public void createUser(String email, String firstName, String secondName, String password) {
        usersService.createUser(email, firstName, secondName, password);
    }
}
