package model;

import java.util.ArrayList;
import java.util.List;

import types.Coordinate;
import types.Direction;
import utils.Connect4Exception;
import types.Token;

public class Board {
    private static final int numberOfRows = 6;
    private static final int numberOfColumns = 7;
    private Token tokens[][];
    private Coordinate lastCoordenate;

    public Board() {
        this.tokens = new Token[Board.numberOfRows][Board.numberOfColumns];
    }

    public void setBoardAsClean() {
        for (int x = 0; x < Board.numberOfColumns; x++) {
            for (int y = 0; y < Board.numberOfRows; y++) {
                this.tokens[y][x] = Token.NULL_TOKEN;
            }
        }
    }

    public boolean isConnect4() {

        List<Line> lines = this.createLinesToCheck();
        for (Line line : lines) {
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (line.getCoordinate().isValid()
                        && this.getToken(line.getCoordinate()) == this.getToken(this.lastCoordenate)) {
                    count++;
                }
                line.next();
            }
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    private List<Line> createLinesToCheck() {
        List<Line> lines = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            Coordinate initialCoordinate = new Coordinate(this.lastCoordenate.getRow(),
                    this.lastCoordenate.getColumn());
            lines.add(new Line(initialCoordinate, direction));
        }
        return lines;
    }

    public void put(int column, Token tokenToPut) throws Connect4Exception {
        if (column > Board.numberOfColumns - 1 || column < 0) {
            throw new Connect4Exception("Out of range error ");
        }
        int row = firtsEmptyRow(column);
        this.tokens[row][column] = tokenToPut;
        this.lastCoordenate = new Coordinate(row, column);
    }

    private int firtsEmptyRow(int column) throws Connect4Exception {
        for (int i = 0; i < Board.numberOfRows; i++) {
            if (this.tokens[i][column].isNull()) {
                return i;
            }
        }
        throw new Connect4Exception("Full Column");
    }

    public boolean isCompleted() {
        for (int i = 0; i < Board.numberOfColumns; i++) {
            if (this.tokens[this.tokens.length - 1][i].isNull()) {
                return false;
            }
        }
        return true;
    }

    public static int getnumberOfRows() {
        return numberOfRows;
    }

    public static int getnumberColumns() {
        return numberOfColumns;
    }

    public Token getToken(Coordinate coordinate) {
        return tokens[coordinate.getRow()][coordinate.getColumn()];
    }

}
