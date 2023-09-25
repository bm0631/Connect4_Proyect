package utils;
import java.util.Scanner;

public class Console implements View {
    private static Console instance = new Console();
    public static Object getInstance;
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
      return scanner.nextInt();
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

    public boolean readYesNo() throws Connect4Exception{
         String input = new String("");
       
        input = scanner.next().trim().toUpperCase();
        if (input.equals("YES")||input.equals("Y")){
            return true;
        }else if(input.equals("NO")||input.equals("N")){
            return false;
        }else{
            throw new Connect4Exception("YES NO ERROR");
        }
       
    }
}
