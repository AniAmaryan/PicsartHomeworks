package homework6.service;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileService {
    public static String[] read(String path) throws Exception {
        return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
    }
}
