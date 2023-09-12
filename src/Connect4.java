
public class Connect4 {
	private Board board;
	private Turn turn;
	private View view;
	public Connect4() {
		this.view = Console.getInstance();
		this.board = new Board(this.view);
		this.turn = new Turn(this.board,this.view);
	}

	public static void main(String[] args) {
		new Connect4().play();
	}

	public void play() {

		boolean isConnect4 = false;
		boolean boardCompled = false;

		board.iniciateBoard();
		turn.setFirstPlayer();
		board.printBoard();
		do {
			turn.play();

			board.printBoard();
			isConnect4 = board.isConnect4(turn.currentToken());

			if (!isConnect4) {
				turn.changeTurnPlayer();
			}

			boardCompled = board.isCompleted();
		} while (!isConnect4 && !boardCompled);

		printEndMessage(isConnect4);
		askNewPlay();

	}

	private void printEndMessage(boolean isConnect4) {
		if (isConnect4) {
			System.out.println("Congratulations player " + turn.currentToken() + " you won!!");
		} else {
			System.out.println("Draw well played!!");
		}
	}

	private void askNewPlay() {
		System.out.println("Do you want to play othertime? Y/N");
		/**
		 * String in=System.in.read(null) if (in.equals("Y")) { this.play(); }else {
		 * System.out.println("See you next time"); }
		 **/
	}

}
