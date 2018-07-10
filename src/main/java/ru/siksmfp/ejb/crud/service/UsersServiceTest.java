package ru.siksmfp.ejb.crud.service;


import ru.siksmfp.ejb.crud.conf.SetUpBean;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Artem Karnov @date 7/10/2018.
 * @email artem.karnov@t-systems.com
 */
class UsersServiceTest {
    public void tst() throws NamingException, SQLException {
        System.out.println("Application is starting");
        EJBContainer ec = null;

        Properties p = new Properties();
        p.setProperty(EJBContainer.APP_NAME, "name1");
        ec = EJBContainer.createEJBContainer(p);

        SetUpBean sb = (SetUpBean) ec.getContext().lookupLink("java:global/JavaEECRUD/SetUpBean!ru.siksmfp.ejb.crud.conf.SetUpBean");
        sb.dbRegister();

        UsersService us = (UsersService) ec.getContext().lookupLink("java:global/JavaEECRUD/UsersService!ru.siksmfp.ejb.crud.service.UsersService");
        us.findUserByEmail("email1");
    }
}