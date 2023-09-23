package utils;
import java.util.Scanner;

public class Console implements View {
    private static Console instance = new Console();
    private Scanner scanner = new Scanner((System.in));

    public static Console getInstance() {
        return instance;
    }

    public void write(String string) {
        System.out.print(string);
    }

    public void write(int number) {
        System.out.print(number);
    }

    public void writeln(String string) {
        System.out.print(string);
        System.out.println();
    }


    public void writeln() {
        System.out.println();
    }

    public int readInt() {
        int input = -1;
        do {
            try {
                input = scanner.nextInt();
            } catch (Exception exception) {
                System.out.println("Error, Try again " + exception.getMessage());
                scanner.next();
            }
        } while (input < -1);
        return input;
    }

    public String readString() {
        String input = new String("");
        try {
            input = scanner.next();

        } catch (Exception exception) {
            System.out.println("Error, Try again " + exception.getMessage());
            readString();
        }
        return input;
    }

    public void writeError(String message) {
        System.err.print("Error, Try again " + message);
        this.writeln();
    }
}
