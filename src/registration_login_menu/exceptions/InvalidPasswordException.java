package registration_login_menu.exceptions;

public class InvalidPasswordException extends InvalidUserInputException {
    public InvalidPasswordException(String errorMessage){
        super(errorMessage);
    }
}
