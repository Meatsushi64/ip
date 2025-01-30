public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }
    @Override
    public String toSaveFormat() {
        String done = this.isDone ? "1 ; " : "0 ; ";
        return "T ; " + done + this.description;
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
