package duke.ui;

import java.util.Arrays;
import java.util.ArrayList;
import duke.task.Task;

public class Ui {
    public void print(String ... args) {
        System.out.println(String.format("    %s", "=========================================="));
        Arrays.asList(args).forEach((x) -> { System.out.println(String.format("    %s", x.toString())); } );
        System.out.println(String.format("    %s", "=========================================="));
    }

    public void print(ArrayList<Task> arr) {
        System.out.println(String.format("    %s", "=========================================="));
        if(arr.size() == 0)
            System.out.println("    Nothing to show!");
        else
            arr.forEach((x) -> { System.out.println(String.format("    %d. %s", arr.indexOf(x) + 1, x.toString())); } );
        System.out.println(String.format("    %s", "=========================================="));
    }

    public void print(ArrayList<Task> arr, String header) {
        System.out.println(String.format("    %s", "=========================================="));
        System.out.println(String.format("    %s", header));
        if(arr.size() == 0)
            System.out.println("    Nothing to show!");
        else
            arr.forEach((x) -> { System.out.println(String.format("    %d. %s", arr.indexOf(x) + 1, x.toString())); } );
        System.out.println(String.format("    %s", "=========================================="));
    }
}