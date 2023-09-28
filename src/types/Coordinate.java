package types;

import model.Board;

public class Coordinate {
    private int row;
    private int column;

    public Coordinate(int row, int column) {
        this.row=row;
        this.column=column;
    }

    public void move(Direction direction) {
        int[] moveOffset = direction.getMoveOffset();
        this.row += moveOffset[0];
        this.column += moveOffset[1];
    }

    public int getRow(){
        return this.row;
    }
    
    public int getColumn(){
        return this.column;
    }

    public boolean isValid(){
        return this.row >= 0 && this.column >= 0 && this.row < Board.getnumberOfRows() && this.column < Board.getnumberColumns();
    }

}
