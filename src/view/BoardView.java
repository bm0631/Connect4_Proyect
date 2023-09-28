package view;

import model.Board;
import model.Game;
import types.Coordinate;

public class BoardView extends GameView {

    public BoardView(Game game) {
        super(game);
    }

    public void write() {
        int heigthBoard = Board.getnumberOfRows();
        int widthBoard = Board.getnumberColumns();

        for (int i = heigthBoard - 1; i >= 0; i--) {
            OutPut.writeCell(i);
            for (int j = 0; j < widthBoard; j++) {
                OutPut.writeCell(game.getToken(new Coordinate(i, j)));
                OutPut.COLUMN_SEPARATOR.write();
            }
            OutPut.SPACE.writeln();
        }

        writeFooter(widthBoard);
    }

    private void writeFooter(int widthBoard) {
        OutPut.SPACE.write();
        OutPut.SPACE.write();
        for (int i = 0; i < widthBoard; i++) {
            OutPut.writeCell(i);
        }
        OutPut.SPACE.writeln();
    }
}
