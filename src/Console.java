import java.util.Scanner;

public class Console implements View{
	private static Console instance = new Console();

	public static Console getInstance() {
		return instance;
	}

	private Scanner scanner = new Scanner((System.in));
	
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
		int input=-1;
		try {
			input = scanner.nextInt();
			
		} catch (Exception exception) {
			System.out.println("Error, Try again " + exception.getMessage());
			readInt();
		}
		return input;
	}
	
	public void writeError(String message) {
		System.err.print("Error, Try again "+message);
		this.writeln();
	}
}
