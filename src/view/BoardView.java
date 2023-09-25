package view;

import model.Board;
import model.Game;
import types.Coordinate;
public class BoardView extends GameView{

    public BoardView(Game game) {
        super(game);
    }

    public void write() {
        Board board=game.getBoard();
        int heigthBoard=board.getnumberOfRows();
        int widthBoard=board.getnumberColumns();

        for (int i = heigthBoard-1; i >=0; i--) {
            Out.writeCell(i);
            for (int j = 0; j < widthBoard; j++) {
                Out.writeCell(game.getToken(new Coordinate(i,j)));
                Out.COLUMN_SEPARATOR.write();
            }
            Out.SPACE.writeln();
        }

       writeFooter(widthBoard);
    }
    private void writeFooter(int widthBoard){
         Out.SPACE.write();
         Out.SPACE.write();
         for (int i = 0; i < widthBoard; i++) {
                Out.writeCell(i);
            }
        Out.SPACE.writeln();
    }
}

  
