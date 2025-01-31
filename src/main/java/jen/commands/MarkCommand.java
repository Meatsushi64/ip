package jen.commands;

import jen.OutOfIndexException;
import jen.Storage;
import jen.UI;
/**
 * Represents a command to mark a task as done.
 */
public class MarkCommand extends Command {

    /** The index of the task to be marked as done. */
    private int index;

    /**
     * Constructs a {@code MarkCommand} with the specified task index.
     *
     * @param i The index of the task to be marked as done.
     */
    public MarkCommand(int i) {
        this.index = i;
    }

    /**
     * Executes the mark command.
     * Marks the specified task as done and updates the UI.
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
        storage.markAsDone(index);
        ui.printMessage("I have marked task as done!\n" + storage.taskToString(index) +
                "\n" + storage.sizeToString());
    }
}
