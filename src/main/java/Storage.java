import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static int saveFile(String path, String fileName, ArrayList<Task> arr) {
        try {
            Files.createDirectories(Paths.get(path));
            String filePath = path + "/" + fileName;
            File myObj = new File(filePath);
            myObj.createNewFile();
            FileWriter writer = new FileWriter(filePath);
            for(Task t : arr) {
                writer.write(t.toString());
            }
            writer.close();
            return 0;
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}