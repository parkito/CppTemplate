package com.karnov.crud.controller.controllerUtility;

import com.karnov.crud.entity.Person;
import com.karnov.crud.utility.PageJsonWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Artem Karnov @date 10/17/2017.
 * artem.karnov@t-systems.com
 */
public class RedirectionUtility {

    public static void redirectPersonToHomePage(Person person, HttpServletResponse response, HttpServletRequest request) throws IOException {
        request.setAttribute("person", person);
        response.sendRedirect("/webSide/pages/index.jsp");
    }
}

