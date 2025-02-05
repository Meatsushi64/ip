package jen.commands;
import jen.OutOfIndexException;
import jen.Storage;
import jen.UI;
/**
 * Represents a command to unmark a task as not done.
 */
public class UnmarkCommand extends Command {
    /** The index of the task to be unmarked. */
    private int index;
    /**
     * Constructs an {@code UnmarkCommand} with the specified task index.
     *
     * @param i The index of the task to be unmarked.
     */
    public UnmarkCommand(int i) {
        this.index = i;
    }
    /**
     * Executes the unmark command.
     * Marks the specified task as not done and updates the UI.
     *
     * @param storage The storage containing the task list.
     * @param ui The UI to display messages.
     * @throws OutOfIndexException If the specified index is out of range.
     */
    @Override
    public void run(Storage storage, UI ui) throws OutOfIndexException {
        if (!storage.isWithinSize(this.index)) {
            throw new OutOfIndexException("Input index outside of list size");
        }
        storage.markAsNotDone(index);
        ui.printMessage("I have unmarked the task! \n" + storage.taskToString(index)
                + "\n" + storage.sizeToString());

    }
}
