package jen.tasks;
/**
 * Represents an event task.
 * This task has a description, a start time, and an end time.
 */
public class Event extends Task {

    /** The start time of the event. */
    private String from;

    /** The end time of the event. */

    private String to;

    /**
     * Constructs an {@code Event} task with the specified description, start time, and end time.
     *
     * @param description The description of the event.
     * @param from The start time of the event.
     * @param to The end time of the event.
     */
    public Event(String description, String notes, String from, String to) {
        super(description, notes);
        this.from = from;
        this.to = to;
    }

    /**
     * Converts the event task into a save format string.
     *
     * @return A formatted string representation of the event task for saving.
     */
    @Override
    public String toSaveFormat() {
        String done = this.isDone ? "1 ; " : "0 ; ";
        return "E ; " + done + this.description + " ; " + getNotes() + " ; " + this.from + " ; " + this.to;
    }
    /**
     * Returns a string representation of the event task.
     *
     * @return A formatted string representing the event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + this.to + ")";
    }
}
