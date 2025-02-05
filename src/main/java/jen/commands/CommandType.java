package jen.commands;
/**
 * Represents the type of command that can be executed by the chatbot.
 * This enumeration lists the different types of commands that the chatbot can recognize.
 */
public enum CommandType {
    /** Represents a To-Do command. */
    TODO,

    /** Represents a Deadline command. */
    DEADLINE,

    /** Represents an Event command. */
    EVENT,

    /** Represents a List command to display tasks. */
    LIST,

    /** Represents a Mark command to mark a task as done. */
    MARK,

    /** Represents an Unmark command to mark a task as not done. */
    UNMARK,

    /** Represents a Delete command to remove a task. */
    DELETE,

    /** Represents a Bye command to exit the chatbot. */
    BYE,

    /** Represents a Find command to search for tasks. */
    FIND,

    /** Represents an unknown or unrecognized command. */
    UNKNOWN
}
