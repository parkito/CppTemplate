package com.karnov.crud.controller.person;

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
        response.sendRedirect("/webSide/registration.jsp");
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("secondName");
        String learningGroup = request.getParameter("learningGroup");

        Person person = personService.findPersonByEmail(email);

        if (person == null) {
            Person personForPersisting = new Person();
            personForPersisting.setEmail(email);
            personForPersisting.setPassword(Utility.encryptPassword(password));
            personForPersisting.setFirstName(firstName);
            personForPersisting.setLastName(lastName);
            personForPersisting.setLearningGroup(learningGroup);

            personService.createPerson(personForPersisting);
        } else {
            //send error message to js//send error message to js

        }
    }

}
