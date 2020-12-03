package homework4_5_7.service;

import homework4_5_7.model.Electronics;

public class PCService extends Electronics {
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5\\resources\\pc.txt";

    @Override
    public String toString() {
        return super.toString();
    }

    public PCService() {
        createBasicCritters();
        System.out.println("PC created !!!\n");
    }

    @Override
    public void turnOn() {
        super.turnOn();
    }

    @Override
    public void turnOff() {
        super.turnOff();
    }

    public void writeAllData() throws Exception {
        FileWriterService.writeTxt(PATH, super.toString());
    }
}
