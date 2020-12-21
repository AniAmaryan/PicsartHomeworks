package registration_login.exceptions;

public class InvalidPasswordException extends InvalidUserInputException {
    public InvalidPasswordException(String errorMessage){
        super(errorMessage);
    }
}
