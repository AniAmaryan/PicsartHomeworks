package homework4_5_7.service;

import homework4_5_7.exceptions.IntException;
import homework4_5_7.exceptions.StringException;
import homework4_5_7.model.Tablet;

import java.util.List;
import java.util.Scanner;

public class TabletService extends ElectronicsService implements CameraManager {
    private Tablet tablet;
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5_7\\resources\\tablet.txt";

    public Tablet[] readTabletData() throws Exception, IntException {

        List<String> read = FileReaderService.read(PATH);
        Tablet[] tablets = new Tablet[read.size()];

        for (int i = 0; i < read.size(); i++) {
            String[] notebookArray = read.get(i).split(",");
            tablets[i] = new Tablet();
            tablets[i].setManufacturer(notebookArray[0]);
            tablets[i].setModel(notebookArray[1]);
            tablets[i].setPrice(Integer.parseInt(notebookArray[2]));
            tablets[i].setUnderWarranty(notebookArray[3].equals("Yes"));
            tablets[i].setScreenSize(Double.parseDouble(notebookArray[4]));
            tablets[i].setHasCamera(notebookArray[5].equals("Yes"));
            tablets[i].setCameraResolution(Double.parseDouble(notebookArray[6]));
        }
        return tablets;
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
        final String camera = (tablet.isHasCamera() ? "Yes" : "No");
        final String resolution = "," + tablet.getCameraResolution();
        return super.toString() + camera + resolution;
    }

    public void createTablet() throws StringException, IntException {
        tablet = new Tablet();
        tablet = (Tablet) createBasicCritters(tablet);
        createCameraCritters();
        System.out.println("Tablet created !!!\n");
    }
}
