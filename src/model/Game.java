package model;

import types.Coordinate;
import types.Token;
import utils.Connect4Exception;

public class Game {
    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void start() {
        this.board.setBoardAsClean();
        this.turn.setFirstPlayer();
    }

    public void next() {
        this.turn.changeTurnPlayer();
    }

    public boolean isEnd() {
        return this.isCompleted() || this.isConnect4();
    }

    public boolean isConnect4() {
        return this.board.isConnect4();
    }

    public boolean isCompleted() {
        return this.board.isCompleted();
    }

    public Board getBoard() {
        return this.board;
    }

    public Token getCurrentToken() {
        return this.turn.currentToken();
    }

    public Token getToken(Coordinate coordinate) {
        return this.board.getToken(coordinate);
    }

    public void put(int column) throws Connect4Exception {
        this.board.put(column, turn.currentToken());
    }

}
