import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    public static int saveFile(String folderName, String fileName, ArrayList<Task> arr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        try {
            String dir = System.getProperty("user.dir");
            java.nio.file.Path pp = java.nio.file.Paths.get(dir, folderName);
            Files.createDirectories(Paths.get(folderName));
            String filePath = folderName + "/" + fileName;
            File myObj = new File(filePath);
            myObj.createNewFile();
            FileWriter writer = new FileWriter(filePath);
            StringBuilder sb = new StringBuilder();
            for(Task t : arr) {
                if(t.toString().charAt(1) == 'T')
                    sb.append(String.format("%s,%s,%s,", t.toString().charAt(1), t.isDone?"T":"F", t.getTaskName()) + ";");
                else if(t.toString().charAt(1) == 'D')
                    sb.append(String.format("%s,%s,%s,%s", t.toString().charAt(1), t.isDone?"T":"F", t.getTaskName(), ((DeadlineTask)t).getDueDate().format(formatter)) + ";");
                else if(t.toString().charAt(1) == 'E')
                    sb.append(String.format("%s,%s,%s,%s", t.toString().charAt(1), t.isDone?"T":"F", t.getTaskName(), ((EventTask)t).getDate().format(formatter)) + ";");

            }
            sb.setLength((sb.length() - 1));
            writer.write(sb.toString());
            writer.close();
            return 0;
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
    public static int loadFile(String filePath, TaskList tl) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        try {
            FileInputStream fs = new FileInputStream(filePath);
            Scanner sc = new Scanner(fs);
            String ss = "";
            while (sc.hasNextLine()) {
                ss += sc.nextLine();
            }
            sc.close();
            for(String s : ss.split(";")) {
                String[] args = s.split(",");
                if(args[0].equals("T")) {
                    tl.addTask(new ToDoTask(args[2], args[1] == "T"));
                } else if (args[0].equals("D")) {
                    tl.addTask(new DeadlineTask(args[2], args[1] == "T", LocalDate.parse(args[3], formatter)));
                } else if (args[0].equals("E")) {
                    tl.addTask(new EventTask(args[2], args[1] == "T", LocalDate.parse(args[3], formatter)));
                }
            }
            return 0;
        }
        catch (FileNotFoundException e) {
            return -1;
        }
    }
}