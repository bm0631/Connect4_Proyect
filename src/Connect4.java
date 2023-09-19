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

        if (newPlay()) {
            play();
        }

    }

    private void printEndMessage(boolean isConnect4) {
        if (isConnect4) {
            view.writeln("Congratulations player " + turn.currentToken() + " you won!!");
        } else {
            view.writeln("Draw well played!!");
        }
    }

    private boolean newPlay() {
        String answer;
        view.writeln("Do you want to play othertime? Y/N");
        answer = view.readString().toUpperCase();

        if (answer.equals("Y") || answer.equals("YES")) {
            return true;
        } else {
            return false;
        }
    }

}
