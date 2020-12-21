package registration_login;

import registration_login.model.User;
import registration_login.services.UserService;

import java.util.Scanner;

public class Main {
    private static boolean flag = true;
    public static void main(String[] args) throws Exception {
        System.out.println("----------------------------------");
        System.out.println("\tWelcome to register and log in to the system\t");
        System.out.println("----------------------------------");
        while (flag) {
            menu();
        }
    }

    public static void menu() throws Exception {
        System.out.println("1. Registration");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.println("Please enter the operation and end with the Enter key:");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        UserService userService = new UserService();
        switch (option) {
            case 1: {
                User user = new UserService().create();
                userService.writeAllData(user);
                break;
            }
            case 2: {
                userService.loginUser();
                break;
            }
            case 3:
                flag = false;
                break;
            default:
                System.out.println("I'm Sorry,there is not the " + option + " option,please try again.");
        }
    }
}
