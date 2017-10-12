package com.karnov.crud.controller.person;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.karnov.crud.entity.Person;
import com.karnov.crud.service.PersonService;
import com.karnov.crud.utility.DIContainer;

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
//        String firstName = request.getParameter("firstName");
//        String lastName = request.getParameter("secondName");
//        String learningGroup = request.getParameter("learningGroup");

        Person person = new Person();
        person.setEmail(email);
        person.setPassword(password);

        System.out.println(email + " " + password);

        // 2. initiate jackson mapper
        ObjectMapper mapper = new ObjectMapper();

        // 3. Convert received JSON to Article
//        Article article = mapper.readValue(json, Article.class);

        // 4. Set response type to JSON
        response.setContentType("application/json");

        // 5. Add article to List<Article>
//        articles.add(article);

        // 6. Send List<Article> as JSON to client
        mapper.writeValue(response.getOutputStream(), person);

        response.setStatus(HttpServletResponse.SC_OK);

//        while (request.getAttributeNames().hasMoreElements()) {
//            System.out.println(request.getAttributeNames().nextElement());
//        }

//        Person person = personService.findPersonByEmail(email);

//        if (person == null) {
//            Person personForPersisting = new Person();
//            personForPersisting.setEmail(email);
//            personForPersisting.setPassword(Utility.encryptPassword(password));
//            personForPersisting.setFirstName(firstName);
//            personForPersisting.setLastName(lastName);
//            personForPersisting.setLearningGroup(learningGroup);
//
//            personService.createPerson(personForPersisting);
//        } else {
//            //send error message to js//send error message to js
//
//        }
    }

}
