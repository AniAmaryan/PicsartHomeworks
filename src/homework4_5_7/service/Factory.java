package homework4_5_7.service;

import homework4_5_7.exceptions.IntException;

import java.util.Scanner;

public class Factory {

    public void showMenu() throws Exception, IntException {
        Scanner scanner = new Scanner(System.in);
        String option;

        do {
            mainMenuStart();
            option = scanner.next();
            switch (option.toUpperCase().charAt(0)) {
                case 'A':
                    PCService pcService = new PCService();
                    pcService.createPc();
                    pcService.writeAllData();
                    pcService.start();
                    break;
                case 'B':
                    NotebookService notebookService = new NotebookService();
                    notebookService.createNotebook();
                    notebookService.writeAllData();
                    notebookService.start();
                    break;
                case 'C':
                    TVService tvService = new TVService();
                    tvService.createTV();
                    tvService.writeAllData();
                    tvService.start();
                    break;
                case 'D':
                    PhoneService phoneService = new PhoneService();
                    phoneService.createPhone();
                    phoneService.writeAllData();
                    phoneService.start();
                    break;
                case 'E':
                    TabletService tabletService = new TabletService();
                    tabletService.createTablet();
                    tabletService.writeAllData();
                    tabletService.start();
                    break;
                case 'F':
                    CatalogService catalogService = new CatalogService();
                    catalogService.sortCatalog();
                    break;
                default:
                    System.out.println("Wrong command, returning previous menu");
                    break;
            }
        } while (option.charAt(0) != 'X');
        System.out.println("Thank you for using our service");
    }

    private static void mainMenuStart() {
        System.out.println("-----MENU-----");
        System.out.println("A. Create PC");
        System.out.println("B. Create Notebook");
        System.out.println("C. Create TV");
        System.out.println("D. Create Phone");
        System.out.println("E. Create Tablet");
        System.out.println("F. Catalog");
        System.out.println("X. Exit");
        System.out.println();
        System.out.println("Choose an option");
        System.out.println();
    }
}

