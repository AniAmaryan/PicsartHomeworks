package homework4_5.model;

public class PC extends Electronics {

    public PC() {
        createBasicCritters();
        System.out.println("PC created !!!\n");
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void turnOn() {
        System.out.println("The PC is on");
    }

    @Override
    public void turnOff() {
        System.out.println("The PC is off");
    }
}
