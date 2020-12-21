package registration_login.exceptions;

public class InvalidUserInputException extends Exception {
    public InvalidUserInputException(){
        super("You entered invalid field");
    }
    public InvalidUserInputException(String errorMessage){
        super(errorMessage);
    }
}
