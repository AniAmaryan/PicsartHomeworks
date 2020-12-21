package registration_login_menu.exceptions;

public class InvalidUsernameException extends InvalidUserInputException {
    public InvalidUsernameException(String errorMessage){
        super(errorMessage);
    }
}
