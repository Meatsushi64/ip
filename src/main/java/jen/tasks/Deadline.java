package jen.tasks;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Represents a task with a deadline.
 * This task has a description and a due date.
 */
public class Deadline extends Task {
    // reference from cs2103 website
    /** The due date of the deadline task. */
    protected LocalDate by;

    /**
     * Constructs a {@code Deadline} task with the specified description and due date.
     *
     * @param description The description of the deadline task.
     * @param by The due date of the task.
     */
    public Deadline(String description, String notes, LocalDate by) {
        super(description, notes);
        this.by = by;
    }
    /**
     * Converts the deadline task into a save format string.
     *
     * @return A formatted string representation of the task for saving.
     */
    @Override
    public String toSaveFormat() {
        String done = this.isDone ? "1 ; " : "0 ; ";
        return "D ; " + done + this.description + " ; " + getNotes() + ";" + this.by;
    }
    /**
     * Returns a string representation of the deadline task.
     *
     * @return A formatted string representing the deadline task.
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

}
