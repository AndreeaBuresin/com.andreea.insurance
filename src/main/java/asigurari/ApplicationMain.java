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
                        System.out.printf("Alegere necunoscuta:  '%s'. Incearca din nou.  %n%n%n",
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
            String cnpNr = read("Va rugam introduceti CNP-ul: ");
            if (Validation.cnpValidation(cnpNr)) {
                isValid = true;

                List<Persoana> personsByCNP = persoanaController.findByColumn("cnp", cnpNr);
                if (personsByCNP.isEmpty()) {
                    long nr = Long.parseLong(cnpNr);
                    persoana.setCnp(nr);
                } else {
                    System.out.println("Acest CNP exista deja in baza noastra de date!");
                    isValid = false;
                }
            } else {
                isValid = false;
                System.out.println("CNP-ul introdus nu este unul valid!");
            }
        } while (isValid == false);

        do {
            System.out.println("Va rugam alegeti tipul persoanei pe care doriti sa o introduceti in " +
                    "baza de date.");
            System.out.println("1. Angajat");
            System.out.println("2. Colaborator");
            System.out.println("3. Asigurat");

            Scanner scan = new Scanner(System.in);
            String optionString = scan.next();
            int option = 0;
            if (Validation.isPositiveInt(optionString)) {
                option = Integer.parseInt(optionString);
                if (option >= 1 && option <= 3) {

                        switch (option) {
                            case 1:
                                for (TipPersoana tipulPersoana: TipPersoana.values()) {
                                    tipulPersoana = TipPersoana.ANGAJAT;
                                    tipulPersoana.setValue("Angajat");
                                    persoana.setTipPersoana(tipulPersoana);
                                }
                                break;
                            case 2:
//                                for (TipPersoana tipPersoana : TipPersoana.values()) {
//                                    tipPersoana = TipPersoana.COLABORATOR;
//                                    tipPersoana.setValue("Colaborator");
//                                    persoana.setTipPersoana(tipPersoana);
//                                }
                                break;
                            case 3:
//                                for (TipPersoana tipPersoana : TipPersoana.values()) {
//                                    tipPersoana = TipPersoana.ASIGURAT;
//                                    tipPersoana.setValue("Asigurat");
//                                    persoana.setTipPersoana(tipPersoana);
//                                }
                                break;
                    }
                } else {
                    System.out.println("Alegerea dvs nu este corecta!");
                }
            } else {
                System.out.println("Alegeti un numar din lista de mai sus");
            }
        }
        while (isValid == false);

        do {
            String numelepersoanei = read("Va rugam introduceti numele " +
                    "\n(numele trebuie sa fie un cuvant de minim 3 si maxim 20 litere, " +
                    "numele trebuie sa inceapa cu litera mare):\n");
            if (Validation.nameValidation(numelepersoanei)) {
                isValid = true;
                persoana.setNume(numelepersoanei);
            } else {
                isValid = false;
                System.out.println("Numele introdus nu este valid!");
            }
        } while (isValid == false);

        do {
            String prenumelePersoanei = read("Va rugam introduceti prenumele"
                    + "\n(numele trebuie sa fie un cuvant de minim 3 si maxim 20 litere, " +
                    "numele trebuie sa inceapa cu litera mare):\n");
            if (Validation.nameValidation(prenumelePersoanei)) {
                isValid = true;
                persoana.setPrenume(prenumelePersoanei);
            } else {
                isValid = false;
                System.out.println("Prenumele introdus nu este valid!");
            }
        } while (isValid == false);

        do {
            String telefon = read("Va rugam introduceti numarul de telefon: ");
            if (Validation.isPhoneNumber(telefon)) {
                isValid = true;
                long nr = Long.parseLong(telefon);
                persoana.setTelefon(nr);
            } else {
                isValid = false;
                System.out.println("Acest numar de telefon nu este valid!");
            }
        } while (isValid == false);

        do {
            String mail = read("Va rugam introduceti o adresa de e-mail: ");
            if (Validation.isEmail(mail)) {
                isValid = true;
                persoana.setEmail(mail);
            } else {
                isValid = false;
                System.out.println("Aceasta adresa de e-mail nu este valida!");
            }
        } while (isValid == false);
        System.out.println(persoana);
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

    private void stergePersoana() throws Exception {

        persoanaController.findAll();
        String persoanaIdString;

        do {
            System.out.println("Introduceti id-ul persoanei pe care doriti sa o stergeti din baza de date: ");
            System.out.println(persoanaController.findAll());
            persoanaIdString = consoleReader.readLine();

        } while (!Validation.isPositiveInt(persoanaIdString));
        int persoanaId = Integer.parseInt(persoanaIdString);
        Persoana persoana = persoanaController.findById(persoanaId);
        if (persoana != null) {
            persoanaController.delete(persoana);
        } else {
            System.out.println("Persoana cautata nu exista in baza noastra de date!");
            stergePersoana();
        }

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
        System.out.println("Va rugam alegeti o categorie din lista de mai sus: ");
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
