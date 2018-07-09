package ru.siksmfp.ejb.crud;

import ru.siksmfp.ejb.crud.conf.SetUpBean;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Artem Karnov @date 7/9/2018.
 * @email artem.karnov@t-systems.com
 */
public class Main {

    public static void main(String[] args) throws NamingException, SQLException {
        Main main = new Main();
        main.so();
    }

    public void so() throws NamingException {
        System.out.println("Application is starting");
        EJBContainer ec = null;
        Map<String, Object> properties = new HashMap<>();
        ec = EJBContainer.createEJBContainer();
        ec.getContext().lookupLink("UserService");
    }
}
