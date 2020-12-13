package homework4_5_7.service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileReaderService {
    public static List<String> read(String path) throws Exception {
        return Files.readAllLines(Paths.get(path));
    }
}
