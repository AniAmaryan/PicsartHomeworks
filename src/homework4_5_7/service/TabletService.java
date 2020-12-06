package homework4_5_7.service;

import homework4_5_7.exceptions.IntException;
import homework4_5_7.exceptions.StringException;
import homework4_5_7.model.Electronics;
import homework4_5_7.model.Tablet;

import java.util.Scanner;

public class TabletService extends Electronics implements CameraManager {
    private Tablet tablet;
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5_7\\resources\\tablet.txt";

    public Tablet[] readTabletData() throws Exception, IntException {

        String[] read = FileReaderService.read(PATH);
        Tablet[] tablets = new Tablet[read.length];

        for (int i = 0; i < read.length; i++) {
            String[] notebookArray = read[i].split(",");
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

    public void sortByPrice(Tablet[] tablets){
        System.out.println("----------------------");
        System.out.println("Sorting By Price: ");
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 1; i < tablets.length; i++) {
                if (tablets[i - 1].getPrice() > tablets[i].getPrice()) {
                    Tablet temp = tablets[i];
                    tablets[i] = tablets[i - 1];
                    tablets[i - 1] = temp;
                    swapped = true;
                }
            }
        }
        for (Tablet tablet : tablets) {
            System.out.println(tablet.print());
        }
    }

    @Override
    public void turnOn() {
        System.out.println("The Tablet is on");
    }

    @Override
    public void turnOff() {
        System.out.println("The Tablet is off");
    }

    public void createTablet() throws StringException, IntException {
        tablet = new Tablet();
        createBasicCritters();
        createCameraCritters();
        System.out.println("Tablet created !!!\n");
    }
}
