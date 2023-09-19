import java.util.Random;

public class Turn {

    private final int NUMBER_PLAYERS = 2;
    private Player players[];
    private Board board;
    private Player currentPlayer;
    private View view;

    public Turn(Board board, View view) {
        this.board = board;
        this.view = view;
        createPlayers();
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
        players[0] = new Player(Token.X_TOKEN, this.board, this.view);
        players[1] = new Player(Token.O_TOKEN, this.board, this.view);
    }

    public void setFirstPlayer() {
        int firstIdPlayer;
        firstIdPlayer = randomPlayer();
        this.currentPlayer = players[firstIdPlayer];
    }

    public void play() {
        try {
            currentPlayer.put();
        } catch (Exception e) {
            view.writeError(e.getMessage());
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
