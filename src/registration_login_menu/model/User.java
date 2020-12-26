package registration_login_menu.model;

import registration_login_menu.services.MD5AlgorithmService;
import registration_login_menu.services.UserValidationService;
import registration_login_menu.exceptions.*;
import java.io.IOException;

public class User {
    private String fullName;
    private String username;
    private String email;
    private String password;

    public User(String fullName, String username, String email, String password) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.password = MD5AlgorithmService.md5(password);
    }

    public User() {
    }

    @Override
    public String toString() {
        return getFullName() + "," + getUsername() + "," + getEmail() + "," + getPassword() + "\n";
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) throws InvalidFullNameException {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws InvalidUsernameException, IOException {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InvalidPasswordException {
        this.password = password;
    }
}
