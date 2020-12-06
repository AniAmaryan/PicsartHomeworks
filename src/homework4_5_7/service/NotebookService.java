package homework4_5_7.service;

import homework4_5_7.exceptions.IntException;
import homework4_5_7.exceptions.StringException;
import homework4_5_7.model.Electronics;
import homework4_5_7.model.Notebook;

import java.util.Scanner;

public class NotebookService extends Electronics implements CameraManager {
    private Notebook notebook;
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5_7\\resources\\notebook.txt";

    public Notebook[] readNotebookData() throws Exception, IntException {

        String[] read = FileReaderService.read(PATH);
        Notebook[] notebooks = new Notebook[read.length];

        for (int i = 0; i < read.length; i++) {
            String[] notebookArray = read[i].split(",");
            notebooks[i] = new Notebook();
            notebooks[i].setManufacturer(notebookArray[0]);
            notebooks[i].setModel(notebookArray[1]);
            notebooks[i].setPrice(Integer.parseInt(notebookArray[2]));
            notebooks[i].setUnderWarranty(notebookArray[3].equals("Yes"));
            notebooks[i].setScreenSize(Double.parseDouble(notebookArray[4]));
            notebooks[i].setHasCamera(notebookArray[5].equals("Yes"));
            notebooks[i].setCameraResolution(Double.parseDouble(notebookArray[6]));
        }
        return notebooks;
    }

    //Print notebooks sorted by price
    public void sortByPrice(Notebook[] n) {
        System.out.println("----------------------");
        System.out.println("Sorting By Price: ");
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < n.length; i++) {
                if (n[i - 1].getPrice() > n[i].getPrice()) {
                    Notebook temp = n[i];
                    n[i] = n[i - 1];
                    n[i - 1] = temp;
                    swapped = true;
                }
            }
        }
        for (Notebook notebook : n) {
            System.out.println(notebook.print());
        }
    }

    public NotebookService() {
    }

    public void createNotebook() throws StringException, IntException {
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
        final String camera = (notebook.isHasCamera() ? "Yes" : "No");
        final String resolution = "," + notebook.getCameraResolution();
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
