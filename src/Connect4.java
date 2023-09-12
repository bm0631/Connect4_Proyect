import java.util.Random;

public class Connect4 {
	private Board board;
	private Turn turn;
	public Connect4() {
		this.board=new  Board();
		this.turn=new Turn(this.board);
		play();
	}
	public static void main(String[] args) {
		new Connect4();
	}
	public void play() {

		
		boolean isConnect4 = false;
		boolean boardCompled=false;
		
		board.iniciateBoard();
		turn.setFirstPlayer();
		board.printBoard();
		do {
			turn.play();
			//ASKME quien imprime
			board.printBoard();
			isConnect4 = board.isConnect4(turn.currentToken());
			
			if (!isConnect4) {
				turn.changeTurnPlayer();
			}
			
			boardCompled=board.isCompleted();
		} while (!isConnect4 && !boardCompled);
		
		printEndMessage(isConnect4);
		askNewPlay();
		
		
		turn.play();
	}
	private void printEndMessage(boolean isConnect4) {
		if (isConnect4) {
			System.out.println("Congratulations player "+turn.currentToken()+" you won!!");
		}else {
			System.out.println("Draw well played!!");
		}
	}
	private void askNewPlay() {
		System.out.println("Do you want to play othertime? Y/N");
		/**String in=System.in.read(null)
		if (in.equals("Y")) {
			this.play();
		}else {
			System.out.println("See you next time");
		}**/
	}

}
