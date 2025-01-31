package jen.commands;
import jen.OutOfIndexException;
import jen.Storage;
import jen.UI;
/**
 * Represents an abstract command that can be executed in the chatbot.
 * All specific commands should extend this class and implement the run method.
 */
public abstract class Command {
    /**
     * Executes the command.
     * Each concrete command must define its behavior when run.
     *
     * @param store The storage object that holds the task list.
     * @param ui The UI object that interacts with the user.
     * @throws OutOfIndexException If an invalid index is accessed (applies to certain commands).
     */
    public abstract void run(Storage store, UI ui) throws OutOfIndexException;
}
