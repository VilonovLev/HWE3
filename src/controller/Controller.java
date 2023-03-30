package controller;

import model.facade.Facade;
import model.facade.IFacade;
import utils.InputException;
import view.View;

import java.util.Scanner;

import static utils.ContactPatterns.*;

public class Controller implements IController {
    private Scanner scanner = new Scanner(System.in);
    private IFacade facade = new Facade();
    private View view = new View();

    private String entryString() {
        String result = scanner.nextLine();
        return result.trim().replaceAll(" {2,}"," ");
    }

    private String createContract(String input){
        String result = checkingEntry(input);
        if (result.equals("100")) {
            facade.addContact(input);
        } else {
            try {InputException.CreateInputException(result);}
            catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

    public void run() {
        view.printMessage("0");
        facade.loadContacts();
        while (true) {
            view.printMessage("1");
            String input = entryString();
            view.printMessage(this.createContract(input));
        }
    }

    public static String checkingEntry(String inputStr) {
        try {
            if (inputStr.trim().length() == 0) {
                InputException.CreateInputException("4001");
            } else if (inputStr.split(" ").length != 6) {
                InputException.CreateInputException("4002");
            } else if (!DATE.matcher(inputStr).find()) {
                InputException.CreateInputException("4003");
            } else if (!GENDER.matcher(inputStr).find()) {
                InputException.CreateInputException("4005");
            } else if (!NUMBER_PHONE.matcher(inputStr).find()) {
                InputException.CreateInputException("4007");
            }
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return "100";
    }
}
