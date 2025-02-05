package jen;

/**
 * Represents an exception that is thrown when an index is out of bounds.
 * This exception is used to handle cases where an invalid index is accessed in the Jen chatbot.
 */
public class OutOfIndexException extends Exception {
    /**
     * Constructs a new {@code OutOfIndexException} with the specified detail message.
     *
     * @param message The detail message explaining the reason for the exception.
     */
    public OutOfIndexException(String message) {
        super(message);
    }
}
