package registration_login.exceptions;

public class InvalidUsernameException extends InvalidUserInputException {
    public InvalidUsernameException(String errorMessage){
        super(errorMessage);
    }
}
