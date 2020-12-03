package homework4_5_7.service;

import java.util.Scanner;

public class Factory {

    public void showMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);
        char option;

        do {
            mainMenuStart();
            option = scanner.next().charAt(0);
            switch (option) {
                case 'A':
                    PCService pcService = new PCService();
                    pcService.writeAllData();
                    pcService.start();
                    break;
                case 'B':
                    NotebookService notebookService = new NotebookService();
                    notebookService.writeAllData();
                    notebookService.start();
                    break;
                case 'C':
                    TVService tvService = new TVService();
                    tvService.writeAllData();
                    tvService.start();
                case 'D':
                    PhoneService phoneService = new PhoneService();
                    phoneService.writeAllData();
                    phoneService.start();
                    break;
                case 'E':
                    TabletService tabletService = new TabletService();
                    tabletService.writeAllData();
                    tabletService.start();
                    break;
            }

        } while (option != 'X');
        System.out.println("Thank you for using our service");
    }

    private static void mainMenuStart() {
        System.out.println("-----MENU-----");
        System.out.println("A. Create PC");
        System.out.println("B. Create Notebook");
        System.out.println("C. Create TV");
        System.out.println("D. Create Phone");
        System.out.println("E. Create Tablet");
        System.out.println("X. Exit");
        System.out.println();
        System.out.println("Choose an option");
        System.out.println();
    }
}

