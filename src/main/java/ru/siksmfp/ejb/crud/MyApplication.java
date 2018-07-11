package ru.siksmfp.ejb.crud;

import org.glassfish.embeddable.BootstrapProperties;
import org.glassfish.embeddable.Deployer;
import org.glassfish.embeddable.GlassFish;
import org.glassfish.embeddable.GlassFishException;
import org.glassfish.embeddable.GlassFishProperties;
import org.glassfish.embeddable.GlassFishRuntime;
import ru.siksmfp.ejb.crud.conf.SetUpBean;

import javax.ws.rs.core.Application;
import java.io.File;
import java.sql.SQLException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Arun Gupta
 */
@javax.ws.rs.ApplicationPath("webresources")
public class MyApplication extends Application {

    public static void main(String[] args) throws SQLException {
        try {
            String warName = Optional.ofNullable(System.getProperty("appfile.name")).orElse("app.war");
            String contextroot = Optional.ofNullable(System.getProperty("contextroot")).orElse("root");

            BootstrapProperties bootstrap = new BootstrapProperties();
            GlassFishRuntime runtime = GlassFishRuntime.bootstrap();
            GlassFishProperties glassfishProperties = new GlassFishProperties();
            glassfishProperties.setPort("http-listener", 8083);
            glassfishProperties.setPort("https-listener", 8184);
            GlassFish glassfish = runtime.newGlassFish(glassfishProperties);

            new SetUpBean().dbRegister();
            glassfish.start();

            Deployer deployer = glassfish.getDeployer();

            for (String deployedApplication : deployer.getDeployedApplications()) {
                deployer.undeploy(deployedApplication);
            }

            File war = new File("C:\\Users\\akarnov\\GitHub\\Learning\\JavaEECRUD\\target\\crud-1.0-SNAPSHOT.war");
            if (!war.exists()) {
                System.err.println(warName + " not found");
                throw new GlassFishException("startup error: " + warName + " not found.");
            }

            deployer.deploy(war, "--name=app", "--contextroot=" + contextroot, "--force=true");
            System.err.println(war + " started with --name=app --contextroot=" + contextroot + " --force=true");



        } catch (GlassFishException ex) {
            Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
