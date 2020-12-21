package registration_login.model;

import registration_login.services.MD5AlgorithmService;
import registration_login.services.UserValidationService;
import registration_login.exceptions.*;
import java.io.IOException;

public class User {
    private String fullName;
    private String username;
    private String email;
    private String password;

    @Override
    public String toString() {
        return getFullName() + "," + getUsername() + "," + getEmail() + "," + getPassword() + "\n";
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws InvalidFullNameException {
        UserValidationService.isValidFullName(fullName);
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws InvalidUsernameException, IOException {
        UserValidationService.isValidUsername(username);
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        UserValidationService.isValidEmail(email);
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordException {
        UserValidationService.isValidPassword(password);
        this.password = MD5AlgorithmService.md5(password);

    }
}
