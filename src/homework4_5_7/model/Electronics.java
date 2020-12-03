package homework4_5_7.model;

import homework4_5_7.service.PowerManager;

import java.util.Date;
import java.util.Scanner;

public abstract class Electronics implements PowerManager {
    private String manufacturer;
    private String model;
    private int price;
    private Date creationDate;
    private boolean isUnderWarranty;
    private double screenSize;

    public void createBasicCritters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter manufacturer");
        this.manufacturer = scanner.next();
        System.out.println("Enter model");
        this.model = scanner.next();
        System.out.println("Enter price");
        this.price = scanner.nextInt();
        this.creationDate = new Date();
        System.out.println("Enter is the device under warranty: Y for (Yes) or N for (NO)");
        char answer = scanner.next().charAt(0);
        this.isUnderWarranty = (answer == 'y' || answer == 'Y');
        System.out.println("Enter screenSize");
        this.screenSize = scanner.nextDouble();
    }

    @Override
    public String toString() {
        return "Manufacturer = '" + manufacturer + '\'' + "\n" +
                "Model = '" + model + '\'' + "\n" +
                "Price = " + price + "\n" +
                "CreationDate = " + creationDate + "\n" +
                "IsUnderWarranty = " + (isUnderWarranty ? "Yes" : "No") + "\n" +
                "ScreenSize = " + screenSize + "\n";
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        char answer;
        System.out.println("-----TURN ON/OFF-----");
        System.out.println("You want to turn on device");
        System.out.println("A. Yes");
        System.out.println("B. No");
        System.out.println("X. Exit");
        answer = scanner.next().toUpperCase().charAt(0);
        switch (answer) {
            case 'A':
                turnOn();
                break;
            case 'B':
                turnOff();
                break;
            case 'X':
                System.out.println("Thank you for using our service");
                break;
            default:
                System.out.println("Wrong command, returning previous menu");
                break;
        }
    }

    @Override
    public void turnOn() {
        System.out.println("The device is on");
    }

    @Override
    public void turnOff() {
        System.out.println("The device is off");
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public boolean isUnderWarranty() {
        return isUnderWarranty;
    }

    public void setUnderWarranty(boolean underWarranty) {
        isUnderWarranty = underWarranty;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }
}

