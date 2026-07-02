package exceptions;

public class InvalidPhoneException extends Exception{
    public InvalidPhoneException(String description) {
        System.out.println(description);
    }
}
