package ru.siksmfp.ejb.crud;

import java.sql.SQLException;

/**
 * @author Artem Karnov @date 7/9/2018.
 * @email artem.karnov@t-systems.com
 */
public class Main {

    public static void main(String[] args) throws SQLException {
//        try {
//            String warName = Optional.ofNullable(System.getProperty("appfile.name")).orElse("crud-1.0-SNAPSHOT.war");
//            String contextroot = Optional.ofNullable(System.getProperty("contextroot")).orElse("root");
//
//            BootstrapProperties bootstrap = new BootstrapProperties();
//            GlassFishRuntime runtime = GlassFishRuntime.bootstrap();
//            GlassFishProperties glassfishProperties = new GlassFishProperties();
//            glassfishProperties.setPort("http-listener", 8083);
//            glassfishProperties.setPort("https-listener", 8184);
//            GlassFish glassfish = runtime.newGlassFish(glassfishProperties);
//
//            new SetUpBean().dbRegister();
//            glassfish.start();
//
//            Deployer deployer = glassfish.getDeployer();
//
//            for (String deployedApplication : deployer.getDeployedApplications()) {
//                deployer.undeploy(deployedApplication);
//            }
//
//            File war = new File("C:\\Users\\akarnov\\GitHub\\Learning\\JavaEECRUD\\target\\crud-1.0-SNAPSHOT.war");
//            if (!war.exists()) {
//                System.err.println(warName + " not found");
//                throw new GlassFishException("startup error: " + warName + " not found.");
//            }
//
//            deployer.deploy(war, "--name=app", "--contextroot=" + contextroot, "--force=true");
//            System.err.println(war + " started with --name=app --contextroot=" + contextroot + " --force=true");
//
//
//        } catch (GlassFishException ex) {
//            Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
}
