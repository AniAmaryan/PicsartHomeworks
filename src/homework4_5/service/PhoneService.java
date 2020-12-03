package homework4_5.service;

import homework4_5.model.Electronics;
import homework4_5.model.Phone;

import java.util.Scanner;

public class PhoneService extends Electronics implements CameraManager {
    private Phone phone;
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5\\resources\\phone.txt";

    public PhoneService() {
        phone = new Phone();
        createBasicCritters();
        createCameraCritters();
        System.out.println("Notebook created !!!\n");
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

    @Override
    public String toString() {
        final String camera = "Has Camera = " + (phone.isHasCamera() ? "Yes" : "No");
        final String resolution = "\n" + "Camera Resolution = " + phone.getCameraResolution();
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

}
