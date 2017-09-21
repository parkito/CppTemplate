package com.karnov.crud.controller;

import com.karnov.crud.entity.Person;
import com.karnov.crud.service.PersonService;
import com.karnov.crud.utility.DIContainer;
import com.karnov.crud.utility.Utility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class UserRegistrationController extends HttpServlet {

    private PersonService personService = DIContainer.userServiceInstance();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = new Person();
        person.setEmail("email1");
        person.setFirstName("firstName1");
        person.setLastName("lastName1");
        person.setLearningGroup("learningGroup1");
        person.setPassword(Utility.encryptPassword("password1"));
        personService.createPerson(person);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
