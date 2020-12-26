package registration_login_menu.services;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {
    static List<String> read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path));
    }

    static void write(String path, String text) throws IOException {
        Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.APPEND);
    }
}
