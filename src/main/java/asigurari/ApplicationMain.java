package asigurari;


import asigurari.controller.ControllerFactory;
import asigurari.controller.IController;
import asigurari.data.model.*;
import asigurari.data.repository.GenericRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.logging.Level;
import java.lang.String;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static org.apache.logging.log4j.core.appender.rolling.CompositeTriggeringPolicy.createPolicy;


public class ApplicationMain {
    public static void main(String[] args) {
        System.out.println("Running the application...");

        ApplicationMain application = new ApplicationMain();
        application.run();
    }
    ApplicationMain() {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
    }
    private final static Logger LOGGER = LogManager.getLogger();

    static {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
    }

    private IController<Person> personController = ControllerFactory.createController(Person.class);
    private IController<Policy> policyController = ControllerFactory.createController(Policy.class);
    private IController<Claim> claimController = ControllerFactory.createController(Claim.class);
    private IController<Address> addressController = ControllerFactory.createController(Address.class);
    private IController<FinancialOrders> financialController = ControllerFactory.createController(FinancialOrders.class);
    private IController<Vehicle> vehicleController = ControllerFactory.createController(Vehicle.class);


    private BufferedReader consoleReader;


    private void run() {

        LOGGER.info("Process started ...");
        String choice = "";
        int option = 0;
        do {
            showMenu();
            try {
                choice = promptAction();
                option = Integer.parseInt(choice);
                switch (option) {
                    case 0:
                        break;
                    case 1:
                        createUser();
                        break;
                    case 2:
                        deleteUser();
                        break;
                    case 3:
                        createPolicy();
                        break;
                    case 4:
                        updatePolicy();
                        break;
                    case 5:
                        deletePolicy();
                        break;
                    case 6:
                        createCustomer();
                        break;
                    case 7:
                        deleteCustomer();
                        break;
                    case 8:
                        createFinancialOrder();
                        break;
                    case 9:
                        createClaim();
                        break;
                    case 10:
                        updateClaim();
                        break;
                    case 11:
                        deleteClaim();
                        break;
                    case 12:
                        searchForPayments();
                        break;
                    case 13:
                        searchForClaims();
                        break;
                    case 14:
                        searchForVehicles();
                        break;
                    default:
                        System.out.printf("Unknown choice:  '%s'. Try again.  %n%n%n",
                                choice);
                }
            } catch (Exception ioe) {
                System.out.println(ioe.getMessage());
            }

        } while (option != 0);
        closeEntityManagerObjects();
    }

    private void deletePolicy() {

    }

    private void deleteCustomer() {

    }

    private void deleteClaim() {

    }

    private void deleteUser() {

    }

    private void searchForPayments() {

    }

    private void searchForClaims() {

    }

    private void searchForVehicles() {

    }

    private void updateClaim() {

    }

    private void updatePolicy() {

    }

    private void createClaim() {

    }

    private void createFinancialOrder() {

    }

    private void createCustomer() {

    }

    private void createUser() {

    }

    private String read(String message) {
        String result = null;
        try {
            System.out.print(message);
            result = consoleReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void closeEntityManagerObjects() {
        Optional.ofNullable(GenericRepository.entityManager).ifPresent(EntityManager::close);
        Optional.ofNullable(GenericRepository.entityManagerFactory).ifPresent(EntityManagerFactory::close);
    }

    private String promptAction() throws Exception {
        System.out.println("Choose a category from the above list: ");
        System.out.println();

        String choice = consoleReader.readLine();
        return choice.trim().toLowerCase();
    }

    private void showMenu() {
        System.out.println("0. quit");
        System.out.println("1. Create a new user");
        System.out.println("2. Delete an user");
        System.out.println("3. Create a new policy");
        System.out.println("4. Update a policy");
        System.out.println("5. Delete a policy from database");
        System.out.println("6. Add a new customer in database");
        System.out.println("7. Delete an existing customer");
        System.out.println("8. Register a new financial order");
        System.out.println("9. Create a new claim");
        System.out.println("10.Update an existing claim");
        System.out.println("11.Delete an existing claim");
        System.out.println("12.Search for payments");
        System.out.println("13.Search for an vehicle");
        System.out.println("14.Search for a claim");


    }

}
