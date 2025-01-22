import java.util.Objects;

public class Parser {
    // control centre based on what the user inputs
    // handles what the user inputs into the UI
    boolean status = true; // true means parser turned on

    public void read(String input) {
        if (Objects.equals(input, "bye")) {
            status = false;
        } else {

        }
    }
}
