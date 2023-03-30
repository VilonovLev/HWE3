package view;

public class View {
    public boolean printMessage(String mass) {
        switch (mass){
            case "0":
                System.out.println("Hello! If you want close app and save rows, please entry: exit");
                return true;
            case "1":
                System.out.println("Please entre: " +
                        "Name LastName Patronymic Birthday(dd.mm.yyyy) NumberPhone Gender(f/m)");
                return true;
            case "100":
                System.out.println("Correct entry.");
                return true;
            default:
                System.out.println(mass);
                return false;
        }
    }
}
