package homework4_5.service;

import homework4_5.model.Electronics;
import homework4_5.model.TV;

import java.util.Scanner;

public class TVService extends Electronics {
    private TV tv;
    private final static String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5\\resources\\tv.txt";

    public TVService() {
        tv = new TV();
        createBasicCritters();
        createTVCritters();
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
        final String color = "Is TV Colorful  " + (tv.isColorTV() ? "Yes" : "No");
        final String hd = "\n" + "Is TV Full HD  " + (tv.isFullHD() ? "Yes" : "No");
        return super.toString() + color + hd;
    }

    @Override
    public void turnOn() {
        System.out.println("The TV is on");
    }

    @Override
    public void turnOff() {
        System.out.println("The TV is off");
    }
}
