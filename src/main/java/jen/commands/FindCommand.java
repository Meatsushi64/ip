package jen.commands;

import jen.Storage;
import jen.UI;
/**
 * Represents a command to find tasks that match a keyword.
 */
public class FindCommand extends Command {
    /** The keyword to search for. */
    private String keyword;
    /**
     * Constructs a {@code FindCommand} with the specified keyword.
     *
     * @param keyword The keyword to search for.
     */
    public FindCommand(String keyword) {
        this.keyword = keyword;
    }

    /**
     * Executes the find command.
     * @param storage The storage object that holds the task list.
     * @param ui The UI object that interacts with the user.
     */
    @Override
    public void run(Storage storage, UI ui) {
        ui.printMessage("Here are the matching tasks in your list:\n");
        ui.printMessage(storage.findTasks(keyword));
    }
}
