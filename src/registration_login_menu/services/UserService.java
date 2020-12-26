package registration_login_menu.services;

import registration_login_menu.exceptions.InvalidUserInputException;
import registration_login_menu.model.User;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\registration_login_menu\\resources\\database.txt";
    private final Scanner scanner = new Scanner(System.in);

    public User create() throws InvalidUserInputException, IOException {
        User user = new User();
        System.out.println("Please enter your full name");
        user.setFullName(scanner.nextLine());
        System.out.println("Please enter username (It's length must be more than 10)");
        user.setUsername(scanner.nextLine());
        System.out.println("Please enter your email");
        user.setEmail(scanner.nextLine());
        System.out.println("Please enter password (It's length must be more than 8," +
                " contain 2 uppercase letters and 3 numbers)");
        user.setPassword(scanner.nextLine());

        UserValidationService.isValidUser(user);

        return new User(user.getFullName(), user.getUsername(), user.getEmail(), user.getPassword());
    }

    public void writeAllData(User user) throws Exception {
        FileService.write(PATH, user.toString());
    }

    public void read() throws IOException, InvalidUserInputException {
        List<String> read = FileService.read(PATH);
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < read.size(); i++) {
            User user = new User();
            String[] line = read.get(i).split(",");
            user.setFullName(line[0]);
            user.setUsername(line[1]);
            user.setEmail(line[2]);
            user.setPassword(line[3]);
            userList.add(user);
        }
        System.out.println(userList.toString());
    }

    //Input: username, password
    //Result: Login success or invalid input data
    public void loginUser() throws IOException, InvalidUserInputException {
        User user;
        System.out.println("Please enter your username");
        String userName = scanner.nextLine();
        System.out.println("Please enter your password");
        String password = scanner.nextLine();
        List<String> read = FileService.read(PATH);
        List<User> userList = new ArrayList<>();
        boolean isLoginSuccess = false;
        for (int i = 0; i < read.size(); i++) {
            user = new User();
            String[] line = read.get(i).split(",");
            user.setFullName(line[0]);
            user.setUsername(line[1]);
            user.setEmail(line[2]);
            user.setPassword(line[3]);
            userList.add(user);
            if (userList.get(i).getUsername().equals(userName) &&
                    userList.get(i).getPassword().equals(MD5AlgorithmService.md5(password))) {
                isLoginSuccess = true;
            }
        }
        if (isLoginSuccess) {
            System.out.println("Login success");
        } else {
            System.out.println("Invalid input data");
        }
    }
}
