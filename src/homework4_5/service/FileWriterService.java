package homework4_5.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWriterService {
//    public static Path write(String path, String data) throws Exception {
//        return Files.write(Paths.get(path), data.getBytes());
//    }

    public static void writeTxt(String path, String data) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(path, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            pw.println(data);
            System.out.println("Data Successfully appended into file");
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {// can't do anything } } } // in Java 7 you can do it easily using try-with-resource // statement as shown below try (FileWriter f = new FileWriter("names.txt", true); BufferedWriter b = new BufferedWriter(f); PrintWriter p = new PrintWriter(b);) { p.println("appending text into file"); p.println("Gaura"); p.println("Bori"); } catch (IOException i) { i.printStackTrace(); } }

            }
        }
    }
}
