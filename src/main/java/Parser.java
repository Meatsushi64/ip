import javax.sound.midi.SysexMessage;
import java.util.Objects;

public class Parser {
    // control centre based on what the user inputs
    // handles what the user inputs into the UI


    public Command read(String input) throws JenException{
        String[] arrayInput = input.split(" ", 2);
        String comd = arrayInput[0];
        // System.out.println("length of arrayInput is " + arrayInput.length);
        switch (comd) {
            case "bye":
                return new ByeCommand();
            case "list":
                return new ListCommand();
            case "todo":
                if (arrayInput.length < 2 || arrayInput[1].trim().isEmpty()) {
                    throw new JenException("Todo description cannot be empty!\n" +
                            "Format: todo <desc>");
                }
                return new AddCommand(new ToDo(arrayInput[1].trim()));
            case "deadline":
                if (arrayInput.length < 2 || !arrayInput[1].trim().contains("/by")) {
                    throw new JenException("Deadline command incomplete!\n" +
                            "Format: deadline <desc> /by <time>");
                }
                String[] deadline = arrayInput[1].split(" /by "); // returns [<desc>, <time>]
                if (deadline.length < 2) {
                    throw new JenException("Deadline command does not have a deadline!\n" +
                            "Format: deadline <desc> /by <time>");
                }
                return new AddCommand(new Deadline(deadline[0].trim(), deadline[1].trim()));
            case "event":

                if (arrayInput.length < 2 || !arrayInput[1].trim().contains("/from")
                        || !arrayInput[1].trim().contains("/to")) {
                    // checks if command contains the keywords
                    throw new JenException("Event command incomplete!\nFormat: event <desc> /from <time> /to <time>");
                }

                String[] event = arrayInput[1].split(" /from"); // splits into [<desc>, <time /to time>]
                String desc = event[0].trim(); // extracts <desc>
                String[] timeParts = event[1].split(" /to ", 2); // splits into [<time>, <time>]

                if (timeParts.length < 2 || timeParts[0].trim().isEmpty() || timeParts[1].trim().isEmpty()) {
                    throw new JenException("Event command does not have a complete timeframe!\n" +
                            "Format: event <desc> /from <time> /by <time>");
                }

                String from = timeParts[0].trim();
                String to = timeParts[1].trim();

                return new AddCommand(new Event(desc, from, to));

            case "mark":
                return new MarkCommand(arrayInput[1]);

            case "unmark":
                return new UnmarkCommand(arrayInput[1]);

            default:
                throw new JenException("Sorry, I don't understand your command");
        }

    }
}
