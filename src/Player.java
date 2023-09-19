import java.io.IOException;

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
        return token;
    }

    public void put() throws Connect4Exception, IOException {
        int column;
        column = getCoordinatesToPut();
        board.put(column, token);
    }

    private int getCoordinatesToPut() {
        int column;
        view.writeln("Player " + token.toString() + " is your turn, write a column:");
        column = view.readInt();
        return column;
    }
}
