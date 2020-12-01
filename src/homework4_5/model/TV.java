package homework4_5.model;

import java.util.Scanner;

public class TV extends Electronics {
    private boolean isColorTV;
    private boolean isFullHD;

    public TV() {
        createBasicCritters();
        createTVCritters();
        System.out.println("TV created !!!\n");
    }

    public void createTVCritters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is TV Colorful : Y for (Yes) or N for (NO)");
        char answerForColor = scanner.next().charAt(0);
        this.isColorTV = (answerForColor == 'y' || answerForColor == 'Y');
        System.out.println("Is TV Full HD : Y for (Yes) or N for (NO)");
        char answerForHD = scanner.next().charAt(0);
        this.isFullHD = (answerForHD == 'y' || answerForHD == 'Y');
    }

    @Override
    public String toString() {
        System.out.println("Is TV Colorful  " + (isColorTV ? "Yes" : "No"));
        System.out.println("Is TV Full HD  " + (isFullHD ? "Yes" : "No"));
        return super.toString();
    }

    @Override
    public void turnOn() {
        System.out.println("The TV is on");
    }

    @Override
    public void turnOff() {
        System.out.println("The TV is off");
    }

    public boolean isColorTV() {
        return isColorTV;
    }

    public void setColorTV(boolean colorTV) {
        isColorTV = colorTV;
    }

    public boolean isFullHD() {
        return isFullHD;
    }

    public void setFullHD(boolean fullHD) {
        isFullHD = fullHD;
    }
}

