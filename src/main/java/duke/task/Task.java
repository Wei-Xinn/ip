package duke.task;

public class Task {
    protected String taskName;
    protected boolean isDone;

    Task() {
        this.taskName = "";
        this.isDone = false;
    }

    Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    Task(String taskName, boolean isDone) {
        this.taskName = taskName;
        this.isDone = isDone;
    }

    public String getTaskName() {
        return this.taskName;
    }

    public void mark() {
        this.isDone = true;
    }

    public void unmark() {
        this.isDone = false;
    }

    public boolean isDone() {
        return this.isDone;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.isDone?"X":" ", taskName);
    }
}

