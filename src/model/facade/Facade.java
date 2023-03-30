package model.facade;
import model.data.Contact;
import model.service.ContractServiceImpl;
import utils.ReadFromTxt;
import utils.WriteToTxt;

import javax.naming.spi.DirectoryManager;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.ContactPatterns.*;

public class Facade implements IFacade{
    private ContractServiceImpl contractService = new ContractServiceImpl();

    @Override
    public boolean addContact(String input) {
        String gender = (parse(GENDER,input));
        input = input.replaceAll(GENDER.pattern()," ");
        String phoneNumber = (parse(NUMBER_PHONE,input));
        input = input.replaceAll(NUMBER_PHONE.pattern()," ");
        String birthDay = (parse(DATE,input));
        input = input.replaceAll(DATE.pattern()," ");
        String[] fsc = (input.trim().split(" "));
        boolean result = contractService.createContact(fsc[0], fsc[1], fsc[2], birthDay, phoneNumber, gender);
        if(result) {
            save();
        }
        return result;
    }

    @Override
    public void save() {
        HashSet<Contact> contacts = contractService.getAll();
        Arrays.stream(new File("src\\recources\\").listFiles()).forEach(File::delete);
        for (Contact contact:contacts) {
            String fileName = "src\\recources\\" + contact.getLastName();
            WriteToTxt.write(fileName,contact.toString());
        }
    }

    @Override
    public boolean loadContacts() {
        return loadContacts("src\\recources");
    }

    public boolean loadContacts(String dir){
        File folder = new File(dir);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                Arrays.stream(ReadFromTxt.read(file.getAbsolutePath())
                                .split("\n"))
                        .forEach(row -> addContact(row));
                file.delete();
            }
            return true;
        }
        return false;
    }

    private static String parse(Pattern pattern , String inputStr) {
        Matcher matcher = pattern.matcher(inputStr);
        matcher.find();
        String str = matcher.group().trim();
        return str;
    }
}
