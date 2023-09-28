package utils;

import java.util.Scanner;

public class Console {
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
        int out = Integer.parseInt(this.scanner.nextLine());
        return out;
    }

    public void writeError(String message) {
        System.err.print("Error, Try again " + message);
        this.writeln();
    }

    public boolean readYesNo() throws Connect4Exception {
        String input = new String("");

        input = this.scanner.nextLine().trim().toUpperCase();
        if (input.equals("YES") || input.equals("Y")) {
            return true;
        } else if (input.equals("NO") || input.equals("N")) {
            return false;
        } else {
            throw new Connect4Exception("YES NO ERROR");
        }

    }
}
