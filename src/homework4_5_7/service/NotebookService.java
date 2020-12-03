package homework4_5_7.service;

import homework4_5_7.model.Electronics;
import homework4_5_7.model.Notebook;

import java.util.Scanner;

public class NotebookService extends Electronics implements CameraManager {
    private Notebook notebook;
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5\\resources\\notebook.txt";

    public NotebookService() {
        notebook = new Notebook();
        createBasicCritters();
        createCameraCritters();
        System.out.println("Notebook created !!!\n");
    }

    @Override
    public void createCameraCritters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Has camera : Y for (Yes) or N for (NO)");
        char answer = scanner.next().charAt(0);
        notebook.setHasCamera(answer == 'y' || answer == 'Y');
        System.out.println("Enter camera resolution");
        notebook.setCameraResolution(scanner.nextDouble());
    }

    @Override
    public String toString() {
        final String camera = "Has Camera = " + (notebook.isHasCamera() ? "Yes" : "No");
        final String resolution = "\n" + "Camera Resolution = " + notebook.getCameraResolution();
        return super.toString() + camera + resolution;
    }

    public void writeAllData() throws Exception {
        FileWriterService.writeTxt(PATH, toString());
    }

    @Override
    public void turnOn() {
        System.out.println("The Notebook is on");
    }

    @Override
    public void turnOff() {
        System.out.println("The Notebook is off");
    }

}
