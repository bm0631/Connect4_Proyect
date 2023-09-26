package types;

import model.Board;

public class Coordinate {
    private int row;
    private int column;

    public Coordinate(int row, int column) {
        this.row=row;
        this.column=column;
    }
    public void move(Direction direction){
        switch (direction){
            case NORTH:
                this.row--;
                break;
            case SOUTH:
                this.row++;
                break;
            case EAST:
                this.column++;
                break;
            case WEST:
                this.column--;
                break;
            case NORTHEAST:
                this.row--;
                this.column++;
                break;
            case NORTHWEST:
                this.row--;
                this.column--;
                break;
            case SOUTHEAST:
                this.row++;
                this.column++;
                break;
            case SOUTHWEST:
                this.row++;
                this.column--;
                break;
        }
    }

    public int getRow(){
        return this.row;
    }
    public int getColumn(){
        return this.column;
    }

    public boolean isValid(){
        return this.row >= 0 && this.column >= 0 && this.row < Board.numberOfRows && this.column < Board.numberOfColumns;
    }

}
