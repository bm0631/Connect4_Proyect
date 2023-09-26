package model;
import java.util.Arrays;
import java.util.Random;


public class Turn {

    private final int NUMBER_PLAYERS = 2;
    private Player players[];
    private Board board;
    private Player currentPlayer;
  
    public Turn(Board board) {
        this.board = board;
        this.createPlayers();
    }

    public void changeTurnPlayer() {
    if (!this.board.isConnect4()){
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
             this.players[i] = new Player(Token.getTokenIndex(i));
        }
    }

    public void setFirstPlayer() {
        int firstIdPlayer;
        firstIdPlayer = this.randomPlayer();
        this.currentPlayer = this.players[firstIdPlayer];
    }



    private int randomPlayer() {
        int randomIdPlayer;
        Random randomGenerator = new Random();
        randomIdPlayer = randomGenerator.nextInt(this.NUMBER_PLAYERS);
        return randomIdPlayer;
    }
}
