package jen.tasks;
/**
 * Represents a generic task.
 * This is the base class for different types of tasks.
 */
public class Task {
    /** The description of the task. */
    protected String description;
    /** Indicates whether the task is completed. */
    protected boolean isDone;

    /**
     * Constructs a {@code Task} with the specified description.
     *
     * @param description The description of the task.
     */
    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Returns the status icon of the task.
     *
     * @return "X" if the task is done, otherwise " ".
     */
    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }
    // above referenced from 2103 website

    /**
     * Marks the task as done.
     */
    public void markAsDone() {
        this.isDone = true;
    }
    /**
     * Marks the task as not done.
     */
    public void markAsNotDone() {
        this.isDone = false;
    }

    /**
     * Converts the task into a save format string.
     *
     * @return A formatted string representation of the task for saving.
     */
    public String toSaveFormat() {
        String done = this.isDone ? "1 ; " : "0 ; ";
        return "T ; " + done + this.description;
    }
    /**
     * Returns a string representation of the task.
     *
     * @return A formatted string representing the task.
     */
    @Override
    public String toString() {
        return "[" + getStatusIcon() +"] " + this.description;
    }

    public String getDescription() {
        return this.description;
    }
}
