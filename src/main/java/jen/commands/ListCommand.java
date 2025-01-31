package jen.commands;

import jen.Storage;
import jen.UI;

/**
 * Represents a command to display the list of tasks stored in the chatbot.
 */
public class ListCommand extends Command {

    /**
     * Executes the list command.
     * Displays all the tasks currently stored in the chatbot.
     *
     * @param storage The storage containing the task list.
     * @param ui The UI to display messages.
     */
    @Override
    public void run(Storage storage, UI ui) {
        ui.line();
        storage.printStorage();
        ui.line();
    }
}
