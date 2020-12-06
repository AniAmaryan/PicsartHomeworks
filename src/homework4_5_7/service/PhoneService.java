package homework4_5_7.service;

import homework4_5_7.exceptions.IntException;
import homework4_5_7.exceptions.StringException;
import homework4_5_7.model.Electronics;
import homework4_5_7.model.Phone;

import java.util.Scanner;

public class PhoneService extends Electronics implements CameraManager {
    private Phone phone;
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5_7\\resources\\phone.txt";

    public PhoneService() {
    }

    public Phone[] readPhoneData() throws Exception, IntException {

        String[] read = FileReaderService.read(PATH);
        Phone[] phones = new Phone[read.length];

        for (int i = 0; i < read.length; i++) {
            String[] notebookArray = read[i].split(",");
            phones[i] = new Phone();
            phones[i].setManufacturer(notebookArray[0]);
            phones[i].setModel(notebookArray[1]);
            phones[i].setPrice(Integer.parseInt(notebookArray[2]));
            phones[i].setUnderWarranty(notebookArray[3].equals("Yes"));
            phones[i].setScreenSize(Double.parseDouble(notebookArray[4]));
            phones[i].setHasCamera(notebookArray[5].equals("Yes"));
            phones[i].setCameraResolution(Double.parseDouble(notebookArray[6]));
        }
        return phones;
    }

    @Override
    public void createCameraCritters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Has camera : Y for (Yes) or N for (NO)");
        char answer = scanner.next().charAt(0);
        phone.setHasCamera(answer == 'y' || answer == 'Y');
        System.out.println("Enter camera resolution");
        phone.setCameraResolution(scanner.nextDouble());
    }

    public void writeAllData() throws Exception {
        FileWriterService.writeTxt(PATH, toString());
    }

    public void sortByPrice(Phone[] phones) {
        System.out.println("----------------------");
        System.out.println("Sorting By Price: ");
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < phones.length; i++) {
                if (phones[i - 1].getPrice() > phones[i].getPrice()) {
                    Phone temp = phones[i];
                    phones[i] = phones[i - 1];
                    phones[i - 1] = temp;
                    swapped = true;
                }
            }
        }
        for (Phone phone : phones) {
            System.out.println(phone.print());
        }
    }

    @Override
    public String toString() {
        final String camera = (phone.isHasCamera() ? "Yes" : "No");
        final String resolution = "," + phone.getCameraResolution();
        return super.toString() + camera + resolution;
    }

    @Override
    public void turnOn() {
        System.out.println("The Phone is on");
    }

    @Override
    public void turnOff() {
        System.out.println("The Phone is off");
    }

    public void createPhone() throws StringException, IntException {
        phone = new Phone();
        createBasicCritters();
        createCameraCritters();
        System.out.println("Phone created !!!\n");

    }
}
