package jen.commands;

import jen.Storage;
import jen.UI;

/**
 * Represents a command to exit the chatbot.
 * This command does not perform any action when executed.
 */
public class ByeCommand extends Command {
    /**
     * Executes the bye command.
     * This method does not perform any specific operations.
     *
     * @param store The storage object (not used).
     * @param ui The UI object (not used).
     */
    @Override
    public void run(Storage store, UI ui) {
        ui.printMessage("Goodbye! Hope to see you again soon!");
    }
}
