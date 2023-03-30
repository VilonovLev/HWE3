package utils;

public class InputException extends RuntimeException{
    private InputException(String message) {
        super(message);
    }

    public static void CreateInputException(String index){
        switch (index) {
            case "4001":
                throw new InputException("An empty string has been entered.");
            case "4002":
                throw new InputException("Incorrect information has been entered.");
            case "4003":
                throw new InputException("Incorrect date of birth.");
            case "4005":
                throw new InputException("Incorrect gender indication.");
            case "4007":
                throw new InputException("Incorrect phone number");
        }
    }
}
