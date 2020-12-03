package homework4_5_7.service;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderService {
    public static String[] read(String path) throws Exception {
        return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
    }
}
