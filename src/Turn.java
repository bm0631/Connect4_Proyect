import java.util.Random;

public class Turn {

	private final int NUMBER_PLAYERS = 2;
	private Player players[];
	private Board board;

	public Turn(Board board) {
		this.board = board;i
		createPlayers();
		play();
	}

	public void play() {
		int firstIdPlayer;
		boolean gameEnd=false;
		Player currentPlayer;
		board.iniciateBoard();
		firstIdPlayer=randomPlayer();
		currentPlayer=players[firstIdPlayer];
		do {
			 gameEnd=board.isConnect4(currentPlayer.token)
		} while (gameEnd);
	}
	private void createPlayers() {
		players = new Player[NUMBER_PLAYERS];
		players[0] = new Player(Token.X_TOKEN, this.board);
		players[1] = new Player(Token.O_TOKEN, this.board);
	}
	private int randomPlayer() {
		int randomIdPlayer;
		Random randomGenerator= new Random();
		randomIdPlayer=randomGenerator.nextInt(this.NUMBER_PLAYERS);
		return randomIdPlayer;
	}
}
