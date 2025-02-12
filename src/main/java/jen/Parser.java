package jen;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;

import jen.commands.AddCommand;
import jen.commands.ByeCommand;
import jen.commands.Command;
import jen.commands.CommandType;
import jen.commands.DeleteCommand;
import jen.commands.FindCommand;
import jen.commands.ListCommand;
import jen.commands.MarkCommand;
import jen.commands.UnmarkCommand;
import jen.tasks.Deadline;
import jen.tasks.Event;
import jen.tasks.Task;
import jen.tasks.ToDo;


/**
 * Handles user input parsing and command interpretation.
 * This class processes user commands and converts them into executable actions.
 * Also parses saved task data from storage
 */
public class Parser {
    /**
     * Reads and processes the user input, converting it into a command.
     *
     * @param input The user input string.
     * @return The corresponding {@code Command} object.
     * @throws JenException If the input is invalid or unrecognized.
     */
    public Command read(String input) throws JenException {
        String[] arrayInput = input.split(" ", 2);
        CommandType comd = getCmdType(arrayInput[0]);

        switch (comd) {
        case BYE:
            return new ByeCommand();
        case LIST:
            return new ListCommand();
        case TODO:
            return parseTodoInput(arrayInput);

        case DEADLINE:
            if (arrayInput.length < 2 || !arrayInput[1].trim().contains("/by")) {
                // checks if has sufficient arguments for deadline command
                throw new JenException("Deadline command incomplete!\n"
                        + "Format: deadline <desc> /by <yyyy-mm-dd>");
            }

            assert arrayInput[1].contains("/by") : "Deadline command does not have a deadline!";

            String[] deadline = arrayInput[1].split(" /by "); // returns [<desc>, <time>]
            if (deadline.length < 2) {
                throw new JenException("Deadline command does not have a deadline!\n"
                        + "Format: deadline <desc> /by <yyyy-mm-dd>");
            }
            try {
                // convert user input to LocalDate format
                String dateString = deadline[1].trim();
                LocalDate date = LocalDate.parse(dateString);
                return new AddCommand(new Deadline(deadline[0].trim(), date));

            } catch (DateTimeParseException e) {
                throw new JenException("Deadline command has unreadable date format!\n"
                        + "Format: deadline <desc> /by <yyyy-mm-dd>");
            }

        case EVENT:
            if (arrayInput.length < 2 || !arrayInput[1].trim().contains("/from")
                    || !arrayInput[1].trim().contains("/to")) {
                // checks if command contains the keywords
                throw new JenException("Event command incomplete!\nFormat: event <desc> /from <time> /to <time>");
            }

            assert arrayInput[1].contains("/from") : "Event command does not have a start time!";
            assert arrayInput[1].contains("/to") : "Event command does not have an end time!";

            String[] event = arrayInput[1].split(" /from"); // splits into [<desc>, <time /to time>]
            String desc = event[0].trim(); // extracts <desc>
            String[] timeParts = event[1].split(" /to ", 2); // splits into [<time>, <time>]

            if (timeParts.length < 2 || timeParts[0].trim().isEmpty() || timeParts[1].trim().isEmpty()) {
                throw new JenException("Event command does not have a complete timeframe!\n"
                        + "Format: event <desc> /from <time> /by <time>");
            }

            String from = timeParts[0].trim();
            String to = timeParts[1].trim();

            return new AddCommand(new Event(desc, from, to));

        case DELETE:

            if (arrayInput.length < 2 || arrayInput[1].trim().isEmpty()) {
                throw new JenException("delete command missing index!\n"
                        + "Format: delete <index>");
            }

            assert arrayInput.length > 1 : "Delete command does not have an index!";

            try {
                return new DeleteCommand(Integer.parseInt(arrayInput[1]));
            } catch (NumberFormatException e) {
                throw new JenException("index is not a number!");
            }

        case MARK:
            try {
                return new MarkCommand(Integer.parseInt(arrayInput[1]));
            } catch (NumberFormatException e) {
                throw new JenException("index is not a number!");
            }

        case UNMARK:
            try {
                return new UnmarkCommand(Integer.parseInt(arrayInput[1]));
            } catch (NumberFormatException e) {
                throw new JenException("index is not a number!");
            }

        case FIND:
            if (arrayInput.length < 2 || arrayInput[1].trim().isEmpty()) {
                throw new JenException("find command missing keyword!\n"
                        + "Format: find <keyword>");
            }

            assert arrayInput.length > 1 : "Find command does not have a keyword!";

            return new FindCommand(arrayInput[1].trim());

        default:
            throw new JenException("Sorry, I don't understand your command");
        }
    }
    /**
     * Reads a line from the save file and converts it into a {@code Task} object.
     *
     * @param saveLine The line from the save file.
     * @return The corresponding {@code Task} object.
     * @throws JenException If the save file line is invalid.
     */
    public Task readSaveLine(String saveLine) throws JenException {
        // save line saved as T ; 1 ; title ; extra info
        String[] details = saveLine.split(" ; ");
        switch (details[0]) {
        case "T":
            ToDo t = new ToDo(details[2]);
            if (Objects.equals(details[1], "1")) {
                t.markAsDone();
            }
            return t;
        case "D":
            Deadline d = new Deadline(details[2], LocalDate.parse(details[3]));
            if (Objects.equals(details[1], "1")) {
                d.markAsDone();
            }
            return d;
        case "E":
            Event e = new Event(details[2], details[3], details[4]);
            if (Objects.equals(details[1], "1")) {
                e.markAsDone();
            }
            return e;
        default:
            throw new JenException("Save file read error");
        }
    }
    /**
     * Converts a string command into a {@code CommandType} enum.
     *
     * @param word The command word to be converted.
     * @return The corresponding {@code CommandType}, or {@code UNKNOWN} if not recognized.
     */
    private CommandType getCmdType(String word) {
        try {
            return CommandType.valueOf(word.toUpperCase());
        } catch (IllegalArgumentException e) {
            return CommandType.UNKNOWN;
        }
    }

    /**
     * Parses the user input for a todo command.
     *
     * @param arrayInput The user input split into an array.
     * @return The corresponding {@code Command} object.
     * @throws JenException If the input is invalid or incomplete.
     */
    private Command parseTodoInput(String[] arrayInput) throws JenException {
        if (arrayInput.length < 2 || arrayInput[1].trim().isEmpty()) {
            // checks if input has sufficient arguments, and has a description
            throw new JenException("Todo description cannot be empty!\n"
                    + "Format: todo <desc>");
        }
        assert arrayInput.length > 1 : "Todo command does not have a description!";

        return new AddCommand(new ToDo(arrayInput[1].trim()));
    }
}
