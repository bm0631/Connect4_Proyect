package model;
import java.io.IOException;

import utils.View;

public class Player {
    private Token token;
    private Board board;
    private View view;

    public Player(Token token, Board board, View view) {
        this.token = token;
        this.board = board;
        this.view = view;
    }

    public Token getToken() {
        return this.token;
    }

    public void put() throws Connect4Exception, IOException {
        int column;
        column = this.getCoordinatesToPut();
        this.board.put(column, this.token);
    }
    public boolean isConnect4(){
        return board.isConnect4(this.token);
    }

    private int getCoordinatesToPut() {
        int column;
        this.view.writeln("Player " + this.token.toString() + " is your turn, write a column:");
        column = this.view.readInt();
        return column;
    }
}
