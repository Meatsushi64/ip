public class Event extends Task{
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }
    @Override
    public String toSaveFormat() {
        String done = this.isDone ? "1 ; " : "0 ; ";
        return "E ; " + done + this.description + " ; " + this.from + " ; " + this.to;
    }
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + this.to +")";
    }
}
