import java.util.Objects;

public class Parser {
    // control centre based on what the user inputs
    // handles what the user inputs into the UI


    public Command read(String input) {
        if (Objects.equals(input, "bye")) {
            return new ByeCommand();
        } else if (Objects.equals(input, "list")) {
            return new ListCommand();
        } else {
            return new AddCommand(input);
        }
    }
}
