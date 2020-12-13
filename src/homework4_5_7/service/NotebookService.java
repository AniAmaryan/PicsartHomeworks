package homework4_5_7.service;

import homework4_5_7.exceptions.IntException;
import homework4_5_7.exceptions.StringException;
import homework4_5_7.model.Notebook;

import java.util.List;
import java.util.Scanner;

public class NotebookService extends ElectronicsService implements CameraManager {
    private Notebook notebook;
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5_7\\resources\\notebook.txt";

    public Notebook[] readNotebookData() throws Exception, IntException {

        List<String> read = FileReaderService.read(PATH);
        Notebook[] notebooks = new Notebook[read.size()];

        for (int i = 0; i < read.size(); i++) {
            String[] notebookArray = read.get(i).split(",");
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

    public NotebookService() {
    }

    public void createNotebook() throws StringException, IntException {
        notebook = new Notebook();
        notebook = (Notebook) createBasicCritters(notebook);
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

}
