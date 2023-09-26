package types;

public class Coordinate {
    private int row;
    private int column;
    public Coordinate(int row, int column) {
        this.row=row;
        this.column=column;
    }
    public void move(Direction direction){

    }
    public int getRow(){
        return this.row;
    }
    public int getColumn(){
        return this.column;
    }

}
