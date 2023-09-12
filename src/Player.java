import java.io.IOException;
import java.util.Scanner;

public class  Player{
	private Token token;
	private Board board;

	public Player(Token token, Board board) {
		this.token = token;
		this.board = board;
	}

	public Token getToken() {
		return token;
	}

	public void put() throws Connect4Exception, IOException {
		int column;
			column = getCoordinatesToPut();
			board.put(column, token);	
	}

	private int getCoordinatesToPut() throws IOException {
		int column;
		System.out.println("Player " + token.toString() + " is your turn, write a column:");
		column = (new Scanner(System.in)).nextInt();
		return column;
	}
}
