package model;

import types.Coordinate;
import utils.Connect4Exception;
public class Board {
    private final int numberOfRows = 6;
    private final int numberOfColumns = 7;
    private Token tokens[][];
    private Coordinate lastCoordenate;
    

    public Board( ) {
        this.tokens = new Token[this.numberOfRows][this.numberOfColumns];
    }

    public void setBoardAsClean() {
        for (int x = 0; x < this.numberOfColumns; x++) {
            for (int y = 0; y < this.numberOfRows; y++) {
                this.tokens[y][x] = Token.NULL_TOKEN;
            }
        }
    }

    public boolean isConnect4(Token tokenSeach) {
        boolean isConnect4 = false;
        for (int row = 0; row < this.numberOfRows; row++) {
            for (int column = 0; column < this.numberOfColumns; column++) {
                if (tokenSeach == this.tokens[row][column]) {
                    isConnect4 = checkHorizontal(row, column, tokenSeach) || checkVertical(row, column, tokenSeach)
                            || checkAscendDiagonal(row, column, tokenSeach) || checkDescendDiagonal(row, column, tokenSeach);

                }
                if (isConnect4)
                    return isConnect4;
            }
        }
        return false;
    }
    //TODO
    public boolean isConnect4(){
        //Usar lastCoorde que se guarda
        return false;
    }

    private boolean checkHorizontal(int row, int column, Token tokenSeach) {
        if (column + 3 < this.numberOfColumns) {
            return tokenSeach == this.tokens[row][column + 1] &&
                    tokenSeach == this.tokens[row][column + 2] &&
                    tokenSeach == this.tokens[row][column + 3];
        } else {
            return false;
        }
    }

    private boolean checkVertical(int row, int column, Token tokenSeach) {
        if (row + 3 < this.numberOfRows) {
            return tokenSeach == this.tokens[row + 1][column] &&
                    tokenSeach == this.tokens[row + 2][column] &&
                    tokenSeach == this.tokens[row + 3][column];
        } else {
            return false;
        }
    }

    private boolean checkAscendDiagonal(int row, int column, Token tokenSeach) {
        if (row + 3 < this.numberOfRows && column + 3 < this.numberOfColumns) {
            return tokenSeach == this.tokens[row + 1][column + 1] &&
                    tokenSeach == this.tokens[row + 2][column + 2] &&
                    tokenSeach == this.tokens[row + 3][column + 3];
        } else {
            return false;
        }
    }

    private boolean checkDescendDiagonal(int row, int column, Token tokenSeach) {
        if (row + 3 < this.numberOfRows && column - 3 >= 0) {
            return tokenSeach == this.tokens[row + 1][column - 1] &&
                    tokenSeach == this.tokens[row + 2][column - 2] &&
                    tokenSeach == this.tokens[row + 3][column - 3];
        } else {
            return false;
        }
    }

    public void put(int column, Token tokenToPut) throws Connect4Exception {
        if (column > this.numberOfColumns - 1 || column < 0) {
            throw new Connect4Exception("Out of range error ");
        }
        int row = firtsEmptyRow(column);
        this.tokens[row][column] = tokenToPut;
       this.lastCoordenate = new Coordinate(row, column);
    }

    private int firtsEmptyRow(int column) throws Connect4Exception {
        for (int i = 0; i < this.numberOfRows; i++) {
            if (this.tokens[i][column].isNull()) {
                return i;
            }
        }
        throw new Connect4Exception("Full Column");
    }


    public boolean isCompleted() {
        for (int i = 0; i < this.numberOfRows; i++) {
            for (int j = 0; j < this.numberOfColumns; j++) {
                if (this.tokens[i][j].isNull()) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getnumberOfRows() {
        return numberOfRows;
    }
     public int getnumberColumns() {
        return numberOfColumns;
    }

    public Token getToken(Coordinate coordinate) {
        return tokens[coordinate.getRow()][coordinate.getColumn()];
    }
    
}
