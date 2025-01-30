public class Task {

    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    // above referenced from 2103 website

    public void markAsDone() {
        this.isDone = true;
    }

    public void markAsNotDone() {
        this.isDone = false;
    }
    public String toSaveFormat() {
        String done = this.isDone ? "1 ; " : "0 ; ";
        return "T ; " + done + this.description;
    }

    @Override
    public String toString() {
        return "[" + getStatusIcon() +"] " + this.description;
    }

}
