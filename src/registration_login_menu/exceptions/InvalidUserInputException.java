package registration_login_menu.exceptions;

public class InvalidUserInputException extends Exception {
    public InvalidUserInputException(){
        super("You entered invalid field");
    }
    public InvalidUserInputException(String errorMessage){
        super(errorMessage);
    }
}
