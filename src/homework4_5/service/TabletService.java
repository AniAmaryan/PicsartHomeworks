package homework4_5.service;

import homework4_5.model.Electronics;
import homework4_5.model.Tablet;

import java.util.Scanner;

public class TabletService extends Electronics implements CameraManager {
    private Tablet tablet;
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5\\resources\\tablet.txt";

    public TabletService() {
        tablet = new Tablet();
        createBasicCritters();
        createCameraCritters();
        System.out.println("Notebook created !!!\n");
    }

    @Override
    public void createCameraCritters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Has camera : Y for (Yes) or N for (NO)");
        char answer = scanner.next().charAt(0);
        tablet.setHasCamera(answer == 'y' || answer == 'Y');
        System.out.println("Enter camera resolution");
        tablet.setCameraResolution(scanner.nextDouble());
    }

    public void writeAllData() throws Exception {
        FileWriterService.writeTxt(PATH, toString());
    }

    @Override
    public String toString() {
        final String camera = "Has Camera = " + (tablet.isHasCamera() ? "Yes" : "No");
        final String resolution = "\n" + "Camera Resolution = " + tablet.getCameraResolution();
        return super.toString() + camera + resolution;
    }

    @Override
    public void turnOn() {
        System.out.println("The Tablet is on");
    }

    @Override
    public void turnOff() {
        System.out.println("The Tablet is off");
    }
}
