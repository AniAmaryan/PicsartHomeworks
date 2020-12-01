package homework4_5.model;

import homework4_5.CameraManager;

import java.util.Scanner;

public class Phone extends Electronics implements CameraManager {
    private boolean hasCamera;
    private double cameraResolution;

    public Phone() {
        createBasicCritters();
        createCameraCritters();
        System.out.println("Phone created !!!\n");
    }

    public void createCameraCritters() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter has the phone camera : Y for (Yes) or N for (NO)");
        char answer = scanner.next().charAt(0);
        this.hasCamera = (answer == 'y' || answer == 'Y');
        System.out.println("Enter camera resolution");
        this.cameraResolution = scanner.nextDouble();
    }

    @Override
    public String toString() {
        System.out.println("Has Camera = " + (hasCamera ? "Yes" : "No"));
        System.out.println("Camera Resolution = " + cameraResolution);
        return super.toString();
    }

    @Override
    public void turnOn() {
        System.out.println("The Phone is on");
    }

    @Override
    public void turnOff() {
        System.out.println("The Phone is off");
    }

    public boolean isHasCamera() {
        return hasCamera;
    }

    public void setHasCamera(boolean hasCamera) {
        this.hasCamera = hasCamera;
    }

    public double getCameraResolution() {
        return cameraResolution;
    }

    public void setCameraResolution(double cameraResolution) {
        this.cameraResolution = cameraResolution;
    }
}

