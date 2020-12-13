package homework4_5_7.service;

import homework4_5_7.exceptions.IntException;
import homework4_5_7.model.PC;

import java.util.List;

public class PCService extends ElectronicsService {
    private PC pc;
    private static final String PATH = "C:\\Users\\User\\Desktop\\PicsartHomeworks\\src\\homework4_5_7\\resources\\pc.txt";

    public PC[] readPCData() throws Exception, IntException {

        List<String> read = FileReaderService.read(PATH);
        PC[] pc = new PC[read.size()];
        for (int i = 0; i < read.size(); i++) {
            String[] pcArray = read.get(i).split(",");
            pc[i] = new PC();
            pc[i].setManufacturer(pcArray[0]);
            pc[i].setModel(pcArray[1]);
            pc[i].setPrice(Integer.parseInt(pcArray[2]));
            pc[i].setUnderWarranty(pcArray[3].equals("Yes"));
            pc[i].setScreenSize(Double.parseDouble(pcArray[4]));
        }
        return pc;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public PCService() {
    }

    public void createPc() throws Exception, IntException {
        pc = new PC();
        pc = (PC) createBasicCritters(pc);
        System.out.println("PC created !!!\n");
    }

    public void writeAllData() throws Exception {
        FileWriterService.writeTxt(PATH, super.toString());
    }
}
