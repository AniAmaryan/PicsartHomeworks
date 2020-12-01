package homework4_5;

import homework4_5.model.*;

import java.util.Scanner;

public class Factory {

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        char option;

        do {
            System.out.println();
            System.out.println("A. Create PC");
            System.out.println("B. Create Notebook");
            System.out.println("C. Create TV");
            System.out.println("D. Create Phone");
            System.out.println("E. Create Tablet");
            System.out.println("X. Exit");
            System.out.println();
            System.out.println("Choose an option");
            System.out.println();
            option = scanner.next().charAt(0);
            switch (option) {
                case 'A':
                    PC pc = new PC();
                    System.out.println(pc.toString());
                    pc.start();
                    break;
                case 'B':
                    Notebook notebook = new Notebook();
                    System.out.println((notebook.toString()));
                    notebook.start();
                    break;
                case 'C':
                    TV tv = new TV();
                    System.out.println(tv.toString());
                    tv.start();
                    break;
                case 'D':
                    Phone phone = new Phone();
                    System.out.println(phone.toString());
                    phone.start();
                    break;
                case 'E':
                    Tablet tablet = new Tablet();
                    System.out.println(tablet.toString());
                    tablet.start();
                    break;
                default:
                    System.out.println();
            }

        } while (option != 'X');
        System.out.println("Thank you for using our service");
    }
}

