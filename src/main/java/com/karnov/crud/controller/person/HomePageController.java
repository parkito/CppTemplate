package com.karnov.crud.controller.person;

import com.karnov.crud.controller.controllerUtility.RedirectionUtility;
import com.karnov.crud.entity.Person;
import com.karnov.crud.service.PersonService;
import com.karnov.crud.utility.DIContainer;
import com.karnov.crud.utility.ErrorMessageHolder;
import com.karnov.crud.utility.PageJsonWriter;
import com.karnov.crud.utility.Utility;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Artem Karnov @date 10/17/2017.
 * artem.karnov@t-systems.com
 */
public class HomePageController extends HttpServlet {
    private PersonService personService = DIContainer.userServiceInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/webSide/pages/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ErrorMessageHolder errorMessageHolder = ErrorMessageHolder.Instance();

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Person person = personService.findPersonByEmail(email);
        if (person != null) {
            boolean isPasswordCorrect = Utility.validatePassword(password, person.getPassword());
            if (isPasswordCorrect) {
                RedirectionUtility.redirectPersonToHomePage(person, response, request);
            } else {
                errorMessageHolder.addMessage("Password isn't correct");
                PageJsonWriter.writeObjectToPage(errorMessageHolder.getMessages(), response);
            }
        } else {
            errorMessageHolder.addMessage("User isn't registered in system");
            PageJsonWriter.writeObjectToPage(errorMessageHolder.getMessages(), response);
        }
    }
}
