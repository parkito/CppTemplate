package ru.siksmfp.ejb.crud.conf;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Artem Karnov @date 7/9/2018.
 * @email artem.karnov@t-systems.com
 */
@Startup
@Singleton
public class SetUpBean {
    private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:mydb;create=true";
//    private static final String JDBC_URL = "jdbc:derby:mydb;create=true";

    @PostConstruct
    public void dbRegister() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(JDBC_URL);
        } catch (Exception ex) {
            System.err.println(ex);
        }
        try {
            System.out.println("Database created " + !conn.isClosed());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
