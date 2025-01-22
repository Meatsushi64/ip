import java.util.Scanner;
public class UI {
    private Scanner scanner;
    private Storage storage;

    public UI(){
        scanner = new Scanner(System.in);
    }

    public void greet() { // prints greeting
        System.out.println(Msg.LINE);
        System.out.println(Msg.GREETING);
        System.out.println(Msg.LINE);
    }

    public void line() { // prints a line
        System.out.println(Msg.LINE);
    }

    public String readUserInput() { // reads user input and returns the string
        String s = scanner.nextLine();
        return s;
    }

    public void printMessage(String msg) {
        line();
        System.out.println("Log: " + msg);
        line();
    }
    public void bye() {
        System.out.println(Msg.GOODBYE);
    }
}
