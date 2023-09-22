import java.util.Arrays;
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
        this.createPlayers();
    }

    public void changeTurnPlayer() {
    if (this.players.length > 0) {
        int nextIndex = (Arrays.asList(this.players).indexOf(this.currentPlayer) + 1) % this.players.length;
        this.currentPlayer = this.players[nextIndex];
    }
}

    public Token currentToken() {
        return this.currentPlayer.getToken();
    }

    private void createPlayers() {
        this.players = new Player[NUMBER_PLAYERS];
        for (int i = 0; i < players.length; i++) {
             this.players[i] = new Player(Token.getTokenIndex(i), this.board, this.view);
        }
    }

    public void setFirstPlayer() {
        int firstIdPlayer;
        firstIdPlayer = this.randomPlayer();
        this.currentPlayer = this.players[firstIdPlayer];
    }

    public void play() {
        try {
            this.currentPlayer.put();
        } catch (Exception e) {
            this.view.writeError(e.getMessage());
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
