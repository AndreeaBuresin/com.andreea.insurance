package asigurari;

import asigurari.controller.ControllerFactory;
import asigurari.controller.IController;
import asigurari.data.model.*;
import asigurari.data.repository.GenericRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;


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

    private IController<Adresa> adresaController = ControllerFactory.createController(Adresa.class);
    private IController<Chitanta> chitantaController = ControllerFactory.createController(Chitanta.class);
    private IController<Despagubire> despagubireController = ControllerFactory.createController(Despagubire.class);
    private IController<Persoana> persoanaController = ControllerFactory.createController(Persoana.class);
    private IController<Plata> plataController = ControllerFactory.createController(Plata.class);
    private IController<Polita> politaController = ControllerFactory.createController(Polita.class);
    private IController<Vehicol> vehicolController = ControllerFactory.createController(Vehicol.class);

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
                        System.out.println("Ati iesit din sistem!");
                        break;
                    case 1:
                        creazaPersoana();
                        break;
                    case 2:
                        creazaPolita();
                        break;
                    case 3:
                        adaugaVehicol();
                        break;
                    case 4:
                        adaugaDespagubire();
                        break;
                    case 5:
                        adaugaPlata();
                        break;
                    case 6:
                        stergePersoana();
                        break;
                    case 7:
                        modificaPolita();
                        break;
                    case 8:
                        raportAngajati();
                        break;
                    case 9:
                        raportColaboratori();
                        break;
                    case 10:
                        raportClienti();
                        break;
                    case 11:
                        raportPolite();
                        break;
                    case 12:
                        raportDespagubiri();
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

    private void creazaPersoana() throws Exception {

        Persoana persoana = new Persoana();
        boolean isValid;
        do {
            String cnp = read("Please enter the CNP: ");
            if (Vallidation.cnpValidation(cnp)) {
                isValid = true;
                long nr = Long.parseLong(cnp);

                List<Persoana> personListByCNP = persoanaController.findByColumn("idpersoana(CNP)", String.valueOf(nr));
                if (personListByCNP.size() == 0) {
                    persoana.setCnp(nr);
                } else {
                    System.out.println("This CNP number exist in our database, you can not duplicate it!");
                    isValid = false;
                }
            } else {
                isValid = false;
                System.out.println("Your CNP is not a valid one!");
            }
        } while (isValid == false);

        Persoana.TipPersoana tipulPersoanei = null;
        System.out.println("Va rugam alegeti tipul persoanei pe care doriti sa o introduceti in " +
                "baza de date.");
        do {
            System.out.println("1. Angajat");
            System.out.println("2. Colaborator");
            System.out.println("3. Asigurat");

            Scanner scan = new Scanner(System.in);
            String optionString = scan.next();
            int option = 0;
            if (Vallidation.isPositiveInt(optionString)) {
                option = Integer.parseInt(optionString);
                if (option>=1 && option<=3){
                    switch (option){
                        case 1:{
                            tipulPersoanei = Persoana.TipPersoana.ANGAJAT;
                            persoana.setTipPersoana(Persoana.TipPersoana.ANGAJAT);
                        }
                    }
                } else {



//                tipulPersoanei == Persoana.TipPersoana.ANGAJAT ||
//                        tipulPersoanei == Persoana.TipPersoana.COLABORATOR ||
//                        tipulPersoanei == Persoana.TipPersoana.ASIGURAT

                System.out.println("Alegerea ta nu este corecta!");
            }

        } while (isValid == false);

        do {
            String userNume = read("Va rugam introduceti numele persoanei" +
                    "\n(a string name with minimum of 3 characters and maximum of 20 characters, " +
                    "with uppercase for first letter): ");
            if (Vallidation.nameValidation(userNume)) {
                isValid = true;
                persoana.setNume(userNume);
            } else {
                isValid = false;
                System.out.println("The entered first name is not a valid one!");
            }
        } while (isValid == false);

        do {
            String prenume = read("Please enter the last name"
                    + "\n(a string name with minimum of 3 characters and maximum of 20 characters and with uppercase for first letter): ");
            if (Vallidation.nameValidation(prenume)) {
                isValid = true;
                persoana.setPrenume(prenume);
            } else {
                isValid = false;
                System.out.println("Your last name is not a valid one!");
            }
        } while (isValid == false);

        do {

        } while (isValid == false);

        do {
            String telefon = read("Please enter the phone number: ");
            if (Vallidation.isPhoneNumber(telefon)) {
                isValid = true;
                long nr = Long.parseLong(telefon);
                persoana.setTelefon(nr);
            } else {
                isValid = false;
                System.out.println("This phone number is not a valid one!");
            }
        } while (isValid == false);

        do {
            String mail = read("Please enter the e-mail: ");
            if (Vallidation.isEmail(mail)) {
                isValid = true;
                persoana.setEmail(mail);
            } else {
                isValid = false;
                System.out.println("This e-mail is not a valid one!");
            }
        } while (isValid == false);

        do {

        } while (isValid == false);

        do {

        } while (isValid == false);

        do {

        } while (isValid == false);

        persoanaController.save(persoana);
    }

    private void creazaPolita() {

    }

    private void adaugaVehicol() {

    }

    private void adaugaDespagubire() {

    }

    private void adaugaPlata() {

    }

    private void stergePersoana() {

    }

    private void modificaPolita() {

    }

    private void raportAngajati() {

    }

    private void raportColaboratori() {

    }

    private void raportClienti() {

    }

    private void raportPolite() {

    }

    private void raportDespagubiri() {

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
        System.out.println("0. Iesire din Program.");
        System.out.println("1. Adauga o persoana noua in baza de date.");
        System.out.println("2. Adauga o polita noua in baza de date.");
        System.out.println("3. Adauga un veicol asigurat in baza de date.");
        System.out.println("4. Adauga o despagubire noua in baza de date.");
        System.out.println("5. Adauga o plata noua in baza de date.");
        System.out.println("6. Sterge o persoana din baza de date.");
        System.out.println("7. Modifica o polita.");
        System.out.println("8. Scoate raport angajati.");
        System.out.println("9. Scoate raport colaboratori.");
        System.out.println("10.Scoate raport clienti.");
        System.out.println("11.Scoate raport polite din sistem.");
        System.out.println("12.Scoate raport despagubiri.");

    }

}
