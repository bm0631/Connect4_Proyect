import java.io.IOException;
import java.util.Random;

public class Turn {

	private final int NUMBER_PLAYERS = 2;
	private Player players[];
	private Board board;
	private Player currentPlayer;

	public Turn(Board board) {
		this.board = board;
		createPlayers();
	}

	private void printEndMessage(boolean isConnect4, boolean boardCompled) {
		if (isConnect4) {
			System.out.print("Congratue");
		}
	}

	public void changeTurnPlayer() {
		if (currentPlayer == players[0]) {
			this.currentPlayer = players[1];
		} else {
			this.currentPlayer = players[0];
		}
	}

	public Token currentToken() {
		return currentPlayer.getToken();
	}

	private void createPlayers() {
		players = new Player[NUMBER_PLAYERS];
		players[0] = new Player(Token.X_TOKEN, this.board);
		players[1] = new Player(Token.O_TOKEN, this.board);
	}

	public void setFirstPlayer() {
		int firstIdPlayer;
		firstIdPlayer = randomPlayer();
		this.currentPlayer = players[firstIdPlayer];
	}

	public void play() {
		try {
			currentPlayer.put();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Connect4Exception e) {
			// ASKME como tratamos estas excepciones o no lanzamos excepciones
			System.out.println("Error, Try again "+e.getMessage());
			this.play();
		}
	}

	private int randomPlayer() {
		int randomIdPlayer;
		Random randomGenerator = new Random();
		randomIdPlayer = randomGenerator.nextInt(this.NUMBER_PLAYERS);
		return randomIdPlayer;
	}
}
