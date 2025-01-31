package jen.tasks;
/**
 * Represents a To-Do task.
 * This task only has a description and no additional time constraints.
 */
public class ToDo extends Task {
    /**
     * Constructs a {@code ToDo} task with the specified description.
     *
     * @param description The description of the to-do task.
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Returns a string representation of the to-do task.
     *
     * @return A formatted string representing the to-do task.
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
