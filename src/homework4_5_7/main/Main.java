package homework4_5_7.main;

import homework4_5_7.exceptions.IntException;
import homework4_5_7.service.Factory;

public class Main {

    public static void main(String[] args) throws Exception, IntException {
        Factory factory = new Factory();
        factory.showMenu();
    }
}
