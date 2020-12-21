package registration_login_menu.exceptions;

public class InvalidFullNameException extends InvalidUserInputException {
    public InvalidFullNameException(String errorMessage){
        super(errorMessage);
    }
}
