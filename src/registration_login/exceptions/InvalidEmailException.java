package registration_login.exceptions;

public class InvalidEmailException extends InvalidUserInputException {
    public InvalidEmailException(String errorMessage){
        super(errorMessage);
    }
}
