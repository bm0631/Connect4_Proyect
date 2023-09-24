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

        for (int i = 0; i < heigthBoard; i++) {
          
            for (int j = 0; j < widthBoard; j++) {
                Out.writeCell(new Coordinate(i,j));
            }
            
        }
        

        }
    }

  
