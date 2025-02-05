package jen.commands;
import jen.OutOfIndexException;
import jen.Storage;
import jen.UI;
/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command {
    /** The index of the task to be deleted. */
    private int index;
    /**
     * Constructs a {@code DeleteCommand} with the specified task index.
     *
     * @param i The index of the task to be deleted.
     */
    public DeleteCommand(int i) {
        this.index = i;
    }

    /**
     * Executes the delete command.
     * Removes the specified task from storage and updates the UI.
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
        ui.printMessage("I have removed this task:\n" + storage.deleteItem(this.index)
                + "\n" + storage.sizeToString());
    }
}
