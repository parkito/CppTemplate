package com.karnov.crud.controller;

import com.karnov.crud.entity.Users;
import com.karnov.crud.service.UserService;
import com.karnov.crud.utility.DIContainer;
import com.karnov.crud.utility.Utility;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MainPageController extends HttpServlet {

    private UserService userService = DIContainer.userServiceInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Users user = new Users();
        user.setEmail("email1");
        user.setFirstName("firstName1");
        user.setLastName("lastName1");
//        user.setPassword(Utility.encryptPassword("password1"));
//        user.setGroup("group1");
        userService.createUser(user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");

        // New location to be redirected
        String site = new String("http://www.photofuntoos.com");

        resp.setStatus(resp.SC_MOVED_TEMPORARILY);
        resp.setHeader("Location", site);
    }
}
