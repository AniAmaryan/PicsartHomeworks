package registration_login.exceptions;

public class InvalidFullNameException extends InvalidUserInputException {
    public InvalidFullNameException(String errorMessage){
        super(errorMessage);
    }
}
