public class Connect4 {
    private Board board;
    private Turn turn;
    private View view;

    public Connect4() {
        this.view = Console.getInstance();
        this.board = new Board(this.view);
        this.turn = new Turn(this.board, this.view);
    }

    public static void main(String[] args) {
        Connect4 connect4 = new Connect4();
        connect4.play();
    }

    public void play() {
        do {
            this.playOneGame();
        } while (this.wantToPlayAgain());
    }

    private boolean wantToPlayAgain() {
        String answer;
        this.view.writeln("Do you want to play othertime? Y/N");
        answer = this.view.readString().toUpperCase();
        if (answer.equals("Y") || answer.equals("YES")) {
            return true;
        } else {
            return false;
        }
    }

    private void playOneGame() {
        boolean isConnect4 = false;
        boolean boardCompled = false;
        this.board.setBoardAsClean();
        this.turn.setFirstPlayer();
        this.board.printBoard();
        do {
            this.turn.play();
            this.board.printBoard();
            isConnect4 = this.turn.isConnect4();
            if (!isConnect4) {
                this.turn.changeTurnPlayer();
            }
            boardCompled = this.board.isCompleted();
        } while (!isConnect4 && !boardCompled);

        this.printEndMessage(isConnect4);
    }

    private void printEndMessage(boolean isConnect4) {
        if (isConnect4) {
            this.view.writeln("Congratulations player " + this.turn.currentToken() + " you won!!");
        } else {
            this.view.writeln("Draw well played!!");
        }
    }
}
