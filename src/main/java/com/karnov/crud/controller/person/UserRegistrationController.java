package com.karnov.crud.controller.person;

import com.karnov.crud.entity.Person;
import com.karnov.crud.service.PersonService;
import com.karnov.crud.utility.DIContainer;
import com.karnov.crud.utility.ErrorMessageHolder;
import com.karnov.crud.utility.PageJsonWriter;

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
        ErrorMessageHolder errorMessageHolder = ErrorMessageHolder.Instance();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("secondName");
        String learningGroup = request.getParameter("learningGroup");

        if (email == null || email.isEmpty())
            errorMessageHolder.addMessage("Email field is required");
        if (password == null || password.isEmpty())
            errorMessageHolder.addMessage("Password field is required");
        if (firstName == null || firstName.isEmpty())
            errorMessageHolder.addMessage("First name field is required");
        if (lastName == null || lastName.isEmpty())
            errorMessageHolder.addMessage("Last name field is required");
        if (learningGroup == null || learningGroup.isEmpty())
            errorMessageHolder.addMessage("Learning group field is required");

        if (!errorMessageHolder.isErrorsExists()) {
            Person person = new Person();
            person.setEmail(email);
            person.setPassword(password);
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setLearningGroup(learningGroup);

            PageJsonWriter.writeObjectToPage(person, response);
        } else {
            PageJsonWriter.writeObjectToPage(errorMessageHolder.getMessages(), response);
        }
    }

}
