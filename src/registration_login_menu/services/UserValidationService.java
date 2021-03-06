package registration_login_menu.services;

import registration_login_menu.exceptions.*;
import registration_login_menu.model.User;
import java.io.IOException;
import java.util.List;

public class UserValidationService {
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\registration_login_menu\\resources\\database.txt";

    protected static void isValidEmail(String email) throws InvalidEmailException {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if (!email.matches(regex)) {
            throw new InvalidEmailException("Invalid email");
        }
    }

    protected static void isValidFullName(String fullName) throws InvalidFullNameException {
        String regex = "^[\\p{L} .'-]+$";
        if (!fullName.matches(regex)) {
            throw new InvalidFullNameException("Invalid full name");
        }
    }

    protected static void isValidPassword(String password) throws InvalidPasswordException {
        int countOfUppercase = 0;
        int countOfDigits = 0;
        char chars;
        for (int i = 0; i < password.length(); i++) {
            chars = password.charAt(i);
            if (Character.isUpperCase(chars)) {
                countOfUppercase += 1;
            } else if (Character.isDigit(chars)) {
                countOfDigits += 1;
            }
        }
        if (password.length() < 8 || countOfUppercase < 2 || countOfDigits < 3) {
            throw new InvalidPasswordException("Invalid password");
        }
    }

    protected static void isValidUsername(String username) throws IOException, InvalidUsernameException {
        if (!isValidUsernameLength(username) || !isUsernameDuplicate(username)) {
            throw new InvalidUsernameException("Invalid username");
        }
    }

    protected static boolean isValidUsernameLength(String username) {
        if (username.length() == 0) {
            System.out.println("Your entered username was empty!!!");
            return false;
        }
        return username.length() >= 10;
    }

    protected static boolean isUsernameDuplicate(String username) throws IOException {
        List<String> read = FileService.read(PATH);
        for (String s : read) {
            String[] line = s.split(",");
            if (line[1].equals(username)) {
                return false;
            }
        }
        return true;
    }

    public static void isValidUser(User user) throws InvalidUserInputException, IOException {
        isValidUsername(user.getUsername());
        isValidPassword(user.getPassword());
        isValidEmail(user.getEmail());
        isValidFullName(user.getFullName());
    }
}
