package jen.commands;
import jen.tasks.Task;
import jen.Storage;
import jen.UI;
/**
 * Represents a command to add a task to the task list.
 */
public class AddCommand extends Command{
    /** The task to be added. */
    private Task toAdd;
    /**
     * Constructs an {@code AddCommand} with the specified task.
     *
     * @param task The task to be added.
     */
    public AddCommand(Task task) {
        this.toAdd = task;
    }
    /**
     * Executes the add command.
     * Adds the specified task to storage and updates the UI.
     *
     * @param storage The storage containing the task list.
     * @param ui The UI to display messages.
     */
    @Override
    public void run(Storage storage,  UI ui) {
        storage.store(this.toAdd);
        ui.printMessage("I've added this task to the list! \n" + toAdd + "\n" + storage.sizeToString());

    }
}
