package homework4_5_7.service;

import homework4_5_7.exceptions.IntException;

import java.util.Scanner;

public class CatalogService {
    public void sortCatalog() throws Exception, IntException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Witch electronic device do you want to sort by price\n");
        System.out.println("A. PC");
        System.out.println("B. Notebook");
        System.out.println("C. TV");
        System.out.println("D. Phone");
        System.out.println("E. Tablet");
        System.out.println();
        System.out.println("Choose an option");
        System.out.println();

        String option = scanner.next();
        switch (option.toUpperCase().charAt(0)) {
            case 'A':
                PCService pcService = new PCService();
                pcService.sortByPrice(pcService.readPCData());
                break;
            case 'B':
                NotebookService notebookService = new NotebookService();
                notebookService.sortByPrice(notebookService.readNotebookData());
                break;
            case 'C':
                TVService tvService = new TVService();
                tvService.sortByPrice(tvService.readTVData());
                break;
            case 'D':
                PhoneService phoneService = new PhoneService();
                phoneService.sortByPrice(phoneService.readPhoneData());
                break;
            case 'E':
                TabletService tabletService = new TabletService();
                tabletService.sortByPrice(tabletService.readTabletData());
                break;
            default:
                System.out.println("Wrong command, returning previous menu");
                break;
        }
    }
}
