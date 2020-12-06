package homework4_5_7.service;

import homework4_5_7.exceptions.IntException;
import homework4_5_7.exceptions.StringException;
import homework4_5_7.model.Electronics;
import homework4_5_7.model.TV;

import java.util.Scanner;

public class TVService extends Electronics {
    private TV tv;
    private final static String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5_7\\resources\\tv.txt";

    public TVService() {
    }

    public void sortByPrice(TV[] tvs) {
        System.out.println("----------------------");
        System.out.println("Sorting By Price: ");
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < tvs.length; i++) {
                if (tvs[i - 1].getPrice() > tvs[i].getPrice()) {
                    TV temp = tvs[i];
                    tvs[i] = tvs[i - 1];
                    tvs[i - 1] = temp;
                    swapped = true;
                }
            }
        }
        for (TV tv : tvs) {
            System.out.println(tv.print());
        }
    }

    public TV[] readTVData() throws Exception, IntException {

        String[] read = FileReaderService.read(PATH);
        TV[] tvs = new TV[read.length];

        for (int i = 0; i < read.length; i++) {
            String[] notebookArray = read[i].split(",");
            tvs[i] = new TV();
            tvs[i].setManufacturer(notebookArray[0]);
            tvs[i].setModel(notebookArray[1]);
            tvs[i].setPrice(Integer.parseInt(notebookArray[2]));
            tvs[i].setUnderWarranty(notebookArray[3].equals("Yes"));
            tvs[i].setScreenSize(Double.parseDouble(notebookArray[4]));
            tvs[i].setColorTV(notebookArray[5].equals("Yes"));
            tvs[i].setFullHD(notebookArray[6].equals("Yes"));
        }
        return tvs;
    }

    public void createTVCritters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is TV Colorful : Y for (Yes) or N for (NO)");
        char answerForColor = scanner.next().charAt(0);
        tv.setColorTV(answerForColor == 'y' || answerForColor == 'Y');
        System.out.println("Is TV Full HD : Y for (Yes) or N for (NO)");
        char answerForHD = scanner.next().charAt(0);
        tv.setFullHD(answerForHD == 'y' || answerForHD == 'Y');
    }

    public void writeAllData() throws Exception {
        FileWriterService.writeTxt(PATH, toString());
    }

    @Override
    public String toString() {
        final String color = (tv.isColorTV() ? "Yes" : "No");
        final String fullHD = "," + (tv.isFullHD() ? "Yes" : "No");
        return super.toString() + color + fullHD;
    }

    @Override
    public void turnOn() {
        System.out.println("The TV is on");
    }

    @Override
    public void turnOff() {
        System.out.println("The TV is off");
    }

    public void createTV() throws StringException, IntException {
        tv = new TV();
        createBasicCritters();
        createTVCritters();
        System.out.println("TV created !!!\n");
    }
}
