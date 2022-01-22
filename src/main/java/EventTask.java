import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EventTask extends Task{
    private LocalDate d;

    EventTask(String ss, LocalDate date) {
        this.taskName = ss;
        this.isDone = false;
        this.d = date;
    }
    EventTask(String ss, boolean isDone, LocalDate date) {
        this.taskName = ss;
        this.isDone = isDone;
        this.d = date;
    }


    public LocalDate getDate() {
        return this.d;
    }
    @Override
    public String toString() {
        return String.format("[E][%s] %s (at:%s)", this.isDone?"X":" ", this.taskName, this.d.format(DateTimeFormatter.ofPattern("MMM d yyyy")));
    }

}
