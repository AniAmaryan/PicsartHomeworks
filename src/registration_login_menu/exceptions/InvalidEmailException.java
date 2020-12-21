package registration_login_menu.exceptions;

public class InvalidEmailException extends InvalidUserInputException {
    public InvalidEmailException(String errorMessage){
        super(errorMessage);
    }
}
