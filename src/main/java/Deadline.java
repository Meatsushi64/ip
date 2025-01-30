public class Deadline extends Task {
    // reference from cs2103 website
    protected String by;

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toSaveFormat() {
        String done = this.isDone ? "1 ; " : "0 ; ";
        return "D ; " + done + this.description + " ; " + this.by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }

}
